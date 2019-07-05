package com.televantou.template.ui.splash

import com.televantou.template.data.DataManager
import com.televantou.template.ui.base.BaseViewModel
import com.televantou.template.utils.rx.SchedulerProvider

class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SplashViewInterface>(dataManager, schedulerProvider) {

    fun decideNextActivity() {
        if (dataManager.isLoggedIn) {
            getViewInterface().openMainActivity()

        } else {
            getViewInterface().openLoginActivity()
        }
    }
}


