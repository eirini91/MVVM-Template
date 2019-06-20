package com.pkfcooperparry.template.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.pkfcooperparry.template.BR;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.data.model.db.User;
import com.pkfcooperparry.template.databinding.ActivityLoginBinding;
import com.pkfcooperparry.template.ui.base.BaseActivity;
import com.pkfcooperparry.template.ui.custom.CustomDialog;
import com.pkfcooperparry.template.utils.Navigator;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginViewInterface {


    @Inject
    CustomDialog customDialog;

    @Inject
    Navigator navigator;

    @Inject
    LoginViewModel loginViewModel;

    ActivityLoginBinding activityLoginBinding;

    public static Intent getCallingIntent(@NonNull Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = getViewDataBinding();
        loginViewModel.setViewInterface(this, this);

    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return loginViewModel;
    }

    @Override
    public void handleError(String message) {
        customDialog.showDialog(this, CustomDialog.ONE_BUTTON_DIALOG_STYLE, getString(R.string.something_went_wrong), message);
    }

    @Override
    public void login() {
        loginViewModel.login();
    }

    @Override
    public void openMainActivity(User user) {
        navigator.navigateToMainView(this);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    @Override
    protected int getActionBarType() {
        return KEY_NO_ACTION_BAR;

    }

}
