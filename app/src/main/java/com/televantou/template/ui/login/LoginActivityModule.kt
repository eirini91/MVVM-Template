package com.televantou.template.ui.login

import com.televantou.template.data.DataManager
import com.televantou.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): LoginViewModel {
        return LoginViewModel(dataManager, schedulerProvider)
    }
}
