package com.pkfcooperparry.template.ui.login

import android.databinding.ObservableBoolean
import android.text.Editable
import android.text.TextUtils

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.data.model.db.User
import com.pkfcooperparry.template.ui.base.BaseViewModel
import com.pkfcooperparry.template.utils.CommonUtils
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lombok.Getter
import lombok.Setter


class LoginViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<LoginViewInterface>(dataManager, schedulerProvider) {

    val isValid = ObservableBoolean(false)


    var email: String? = null

    var password: String? = null

    private val isEmailAndPasswordValid: Boolean
        get() {

            if (TextUtils.isEmpty(this.email)) {
                return false
            }
            return if (!this.email?.let { CommonUtils.isEmailValid(it) }!!) {
                false
            } else !TextUtils.isEmpty(this.password) && this.password!!.length >= 6
        }

    fun afterTextChanged(s: Editable) {
        checkIfValid()
    }

    fun checkIfValid() {
        isValid.set(isEmailAndPasswordValid)
    }

    fun getIsPin(): ObservableBoolean {
        return isValid
    }


    fun login() {

         getViewInterface().openMainActivity(User())

    }

    private fun getUserFromApi() {
        setIsLoading(true)
        compositeDisposable.add(dataManager
                .getUserData(dataManager.accessToken, dataManager.currentUserId!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())

                .subscribe({ response ->
                    setIsLoading(false)
                    if (!TextUtils.isEmpty(response.error)) {
                         getViewInterface().handleError(response.error)
                    } else {
                        dataManager.addUser(response)
                         getViewInterface().openMainActivity(response)
                    }
                }, { throwable ->
                    dataManager.setUserAsLoggedOut()

                    setIsLoading(false)
                     getViewInterface().handleError(getHumanReadableError(throwable))
                }))
    }


    fun onServerLoginClick() {
         getViewInterface().login()
    }


}
