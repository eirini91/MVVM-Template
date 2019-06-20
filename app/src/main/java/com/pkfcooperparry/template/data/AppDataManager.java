package com.pkfcooperparry.template.data;

import com.pkfcooperparry.template.data.local.db.DbHelper;
import com.pkfcooperparry.template.data.local.prefs.PreferencesHelper;
import com.pkfcooperparry.template.data.model.api.BaseResponse;
import com.pkfcooperparry.template.data.model.api.LoginResponse;
import com.pkfcooperparry.template.data.model.db.User;
import com.pkfcooperparry.template.data.model.db.visit.Form;
import com.pkfcooperparry.template.data.model.db.visit.Page;
import com.pkfcooperparry.template.data.model.db.visit.Tab;
import com.pkfcooperparry.template.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    private final DbHelper mDbHelper;


    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public void setAccessTokenAndUserId(String accessToken, long userId) {
        mPreferencesHelper.setAccessTokenAndUserId(accessToken, userId);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }


    @Override
    public User getUser() {
        return mDbHelper.getUser();
    }


    @Override
    public void addUser(User user) {
        mDbHelper.addUser(user);
    }


    @Override
    public void updateUser(User user, String firstName, String surname, int sex, int age, String hometown, int positionId, String phone) {
        mDbHelper.updateUser(user, firstName, surname, sex, age, hometown, positionId, phone);
    }

    @Override
    public void deleteAll() {
        mDbHelper.deleteAll();
    }

    @Override
    public Tab getTab(long tabId) {
        return mDbHelper.getTab(tabId);
    }

    @Override
    public Form getFormWithId(int formId) {
        return mDbHelper.getFormWithId(formId);
    }

    @Override
    public Page getPageWithId(int pageId) {
        return mDbHelper.getPageWithId(pageId);
    }

    @Override
    public List<Form> getForms() {
        return mDbHelper.getForms();
    }

    @Override
    public void addForms(List<Form> forms) {
        mDbHelper.addForms(forms);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }


    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
        mDbHelper.deleteAll();
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {

    }

    @Override
    public void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath) {

        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);

        updateApiHeader(userId, accessToken);
    }


    @Override
    public Single<LoginResponse> signIn(String email, String password) {
        return mApiHelper.signIn(email, password);
    }

    @Override
    public Single<User> getUserData(String token, long userId) {
        return mApiHelper.getUserData(token, userId);
    }

    @Override
    public Single<BaseResponse> logout(String token, long userId) {
        return mApiHelper.logout(token, userId);
    }


}
