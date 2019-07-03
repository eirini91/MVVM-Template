package com.pkfcooperparry.template.data

import com.pkfcooperparry.template.data.local.db.DbHelper
import com.pkfcooperparry.template.data.local.prefs.PreferencesHelper
import com.pkfcooperparry.template.data.model.api.BaseResponse
import com.pkfcooperparry.template.data.model.api.LoginResponse
import com.pkfcooperparry.template.data.model.db.User
import com.pkfcooperparry.template.data.model.db.visit.Form
import com.pkfcooperparry.template.data.model.db.visit.Page
import com.pkfcooperparry.template.data.model.db.visit.Tab
import com.pkfcooperparry.template.data.remote.ApiHelper

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable
import io.reactivex.Single

@Singleton
class AppDataManager @Inject
constructor(private val mDbHelper: DbHelper, private val mPreferencesHelper: PreferencesHelper, private val mApiHelper: ApiHelper) : DataManager {


    override var accessToken: String?
        get() = mPreferencesHelper.accessToken
        set(accessToken) {
            mPreferencesHelper.accessToken = accessToken
        }

    override val allUsers: Observable<List<User>>
        get() = mDbHelper.allUsers


    override val user: User
        get() = mDbHelper.user!!

    override val forms: List<Form>
        get() = mDbHelper.forms

    override var currentUserEmail: String?
        get() = mPreferencesHelper.currentUserEmail
        set(email) {
            mPreferencesHelper.currentUserEmail = email
        }

    override var currentUserId: Long?
        get() = mPreferencesHelper.currentUserId
        set(userId) {
            mPreferencesHelper.currentUserId = userId
        }


    override var currentUserName: String?
        get() = mPreferencesHelper.currentUserName
        set(userName) {
            mPreferencesHelper.currentUserName = userName
        }


    override val currentUserLoggedInMode: Int
        get() = mPreferencesHelper.currentUserLoggedInMode

    override val isLoggedIn: Boolean
        get() = false

    override fun setAccessTokenAndUserId(accessToken: String, userId: Long) {
        mPreferencesHelper.setAccessTokenAndUserId(accessToken, userId)
    }


    override fun addUser(user: User) {
        mDbHelper.addUser(user)
    }


    override fun updateUser(user: User, firstName: String, surname: String, sex: Int, age: Int, hometown: String, positionId: Int, phone: String) {
        mDbHelper.updateUser(user, firstName, surname, sex, age, hometown, positionId, phone)
    }

    override fun deleteAll() {
        mDbHelper.deleteAll()
    }

    override fun getTab(tabId: Long): Tab {
        return mDbHelper.getTab(tabId)!!
    }

    override fun getFormWithId(formId: Int): Form {
        return mDbHelper.getFormWithId(formId)!!
    }

    override fun getPageWithId(pageId: Int): Page {
        return mDbHelper.getPageWithId(pageId)!!
    }

    override fun addForms(forms: List<Form>) {
        mDbHelper.addForms(forms)
    }

    override fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode)
    }

    override fun setUserAsLoggedOut() {
        updateUserInfo(
                null, null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT, null, null, null)
        mDbHelper.deleteAll()
    }


    override fun updateApiHeader(userId: Long?, accessToken: String) {
    }

    override fun updateUserInfo(accessToken: String?, userId: Long?, loggedInMode: DataManager.LoggedInMode, userName: String?, email: String?, profilePicPath: String?) {
        this.accessToken = accessToken
        currentUserId = userId
        setCurrentUserLoggedInMode(loggedInMode)
        currentUserName = userName
        currentUserEmail = email

        if (accessToken != null) {
            updateApiHeader(userId, accessToken)
        }
    }


    override fun signIn(email: String, password: String): Single<LoginResponse> {
        return mApiHelper.signIn(email, password)
    }

    override fun getUserData(token: String?, userId: Long): Single<User> {
        return mApiHelper.getUserData(token, userId)
    }

    override fun logout(token: String, userId: Long): Single<BaseResponse> {
        return mApiHelper.logout(token, userId)
    }


}
