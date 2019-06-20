package com.pkfcooperparry.template.data.local.db;

import com.pkfcooperparry.template.data.model.db.User;
import com.pkfcooperparry.template.data.model.db.visit.Form;
import com.pkfcooperparry.template.data.model.db.visit.Page;
import com.pkfcooperparry.template.data.model.db.visit.Tab;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that will include all the DB methods
 */

public interface DbHelper {
    Observable<List<User>> getAllUsers();

    User getUser();

    void addUser(User user);

    void updateUser(User user, String firstName, String surname, int sex, int age,
                    String hometown, int positionId, String phone);

    void deleteAll();

    Tab getTab(long tabId);

    Form getFormWithId(int formId);

    Page getPageWithId(int pageId);

    List<Form> getForms();

    void addForms(List<Form> forms);

}
