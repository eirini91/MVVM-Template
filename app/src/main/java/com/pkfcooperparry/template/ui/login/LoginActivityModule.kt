package com.pkfcooperparry.template.ui.login

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): LoginViewModel {
        return LoginViewModel(dataManager, schedulerProvider)
    }
}
