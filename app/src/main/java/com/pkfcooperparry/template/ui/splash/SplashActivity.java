package com.pkfcooperparry.template.ui.splash;

import android.os.Bundle;
import android.os.Handler;

import com.pkfcooperparry.template.BR;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.databinding.ActivitySplashBinding;
import com.pkfcooperparry.template.ui.base.BaseActivity;
import com.pkfcooperparry.template.utils.Navigator;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashViewInterface {
    private static final int SPLASH_DISPLAY_LENGTH = 1000;
    @Inject
    SplashViewModel splashViewModel;

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel.setViewInterface(this, this);
        Handler handler = new Handler();
        handler.postDelayed(() -> splashViewModel.decideNextActivity(), SPLASH_DISPLAY_LENGTH);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }


    @Override
    public SplashViewModel getViewModel() {
        return splashViewModel;
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    @Override
    protected int getActionBarType() {
        return KEY_NO_ACTION_BAR;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public void openLoginActivity() {
        navigator.navigateToSignInView(this);
    }

    @Override
    public void openMainActivity() {
        navigator.navigateToMainView(this);
    }
}
