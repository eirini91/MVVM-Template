package com.pkfcooperparry.template.ui.splash;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.ui.base.BaseViewModel;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashViewInterface> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void decideNextActivity() {
        if (getDataManager().isLoggedIn()) {
            getViewInterface().openMainActivity();

        } else {
            getViewInterface().openLoginActivity();
        }
    }
}
