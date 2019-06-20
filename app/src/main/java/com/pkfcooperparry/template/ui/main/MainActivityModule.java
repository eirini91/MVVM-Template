package com.pkfcooperparry.template.ui.main;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }
}
