package com.pkfcooperparry.template.ui.splash

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.ui.base.BaseViewModel
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SplashViewInterface>(dataManager, schedulerProvider) {

    fun decideNextActivity() {
        if (dataManager.isLoggedIn) {
            getViewInterface().openMainActivity()

        } else {
             getViewInterface().openLoginActivity()
        }
    }
}


