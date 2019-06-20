package com.pkfcooperparry.template.ui.login;

import android.databinding.ObservableBoolean;
import android.text.Editable;
import android.text.TextUtils;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.data.model.db.User;
import com.pkfcooperparry.template.ui.base.BaseViewModel;
import com.pkfcooperparry.template.utils.CommonUtils;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Getter;
import lombok.Setter;


public class LoginViewModel extends BaseViewModel<LoginViewInterface> {

    private final ObservableBoolean isValid = new ObservableBoolean(false);

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

    LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void afterTextChanged(Editable s) {
        checkIfValid();
    }


    private boolean isEmailAndPasswordValid() {

        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }

    public ObservableBoolean getIsValid() {
        return isValid;
    }

    public void checkIfValid() {
        isValid.set(isEmailAndPasswordValid());
    }

    public ObservableBoolean getIsPin() {
        return isValid;
    }


    public void login() {

        getViewInterface().openMainActivity(new User());


//        if (!isInternetConnectionValid()) {
//            return;
//        }
//        setIsLoading(true);
//        getCompositeDisposable().add(getDataManager()
//                .signIn(email, password)
//                .doOnSuccess(response ->
//                        getDataManager()
//                                .setAccessTokenAndUserId(response.getSessionID(), response.getUserId()))
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(response -> {
//                    setIsLoading(false);
//                    if (!TextUtils.isEmpty(response.getMessage())) {
//                        getViewInterface().handleError(response.getMessage());
//                    } else {
//                        getUserFromApi();
//                    }
//
//                }, throwable -> {
//                    setIsLoading(false);
//                    getViewInterface().handleError(getHumanReadableError(throwable));
//                }));
    }

    private void getUserFromApi() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getUserData(getDataManager().getAccessToken(), getDataManager().getCurrentUserId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())

                .subscribe(response -> {
                    setIsLoading(false);
                    if (!TextUtils.isEmpty(response.getError())) {
                        getViewInterface().handleError(response.getError());
                    } else {
                        getDataManager().addUser(response);
                        getViewInterface().openMainActivity(response);
                    }
                }, throwable -> {
                    getDataManager().setUserAsLoggedOut();

                    setIsLoading(false);
                    getViewInterface().handleError(getHumanReadableError(throwable));
                }));
    }


    public void onServerLoginClick() {
        getViewInterface().login();
    }


}
