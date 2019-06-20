package com.pkfcooperparry.template.data.local.db;

import com.pkfcooperparry.template.data.model.db.User;
import com.pkfcooperparry.template.data.model.db.visit.Form;
import com.pkfcooperparry.template.data.model.db.visit.Page;
import com.pkfcooperparry.template.data.model.db.visit.Tab;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * The class will contain methods to access REALM and return or create data
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final Realm realm;

    @Inject
    public AppDbHelper(Realm appDatabase) {
        this.realm = appDatabase;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(() -> realm.where(User.class).findAll());
    }

    @Override
    public List<Form> getForms() {
        return realm.where(Form.class).findAll();
    }


    @Override
    public User getUser() {
        return realm.where(User.class).findFirst();
    }

    @Override
    public void addUser(final User user) {
        realm.executeTransaction(realm -> realm.copyToRealmOrUpdate(user));
    }

    @Override
    public void updateUser(final User user, final String firstName, final String surname, final int sex, final int age, final String hometown, final int positionId, final String phone) {
        realm.executeTransaction(realm -> {
            user.setName(firstName);
            user.setSurname(surname);
            user.setAge(sex);
            user.setGender(sex);
            user.setAge(age);
            user.setHomeTown(hometown);
            user.setUsualPosition(positionId);
            user.setPhone(phone);
            realm.copyToRealmOrUpdate(user);
        });
    }

    @Override
    public void deleteAll() {
        realm.executeTransaction(realm -> realm.deleteAll());
    }

    @Override
    public Tab getTab(long tabId) {
        return realm.where(Tab.class).equalTo("tabId", tabId).findFirst();
    }

    @Override
    public Form getFormWithId(int formId) {
        return realm.where(Form.class).equalTo("id", formId).findFirst();

    }

    @Override
    public Page getPageWithId(int pageId) {
        return realm.where(Page.class).equalTo("pageId", pageId).findFirst();

    }


    @Override
    public void addForms(List<Form> forms) {
        realm.executeTransaction(realm -> {
            realm.copyToRealmOrUpdate(forms);
            for (Form form : forms) {
                realm.copyToRealmOrUpdate(form.getPages());

                for (Page page : form.getPages()) {
                    realm.copyToRealmOrUpdate(page.getTabs());

                }
            }
        });
    }


}
