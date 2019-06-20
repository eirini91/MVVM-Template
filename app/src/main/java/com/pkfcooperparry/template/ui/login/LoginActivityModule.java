package com.pkfcooperparry.template.ui.login;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager, schedulerProvider);
    }
}
