package com.pkfcooperparry.template.ui.splash;


import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new SplashViewModel(dataManager, schedulerProvider);
    }
}
