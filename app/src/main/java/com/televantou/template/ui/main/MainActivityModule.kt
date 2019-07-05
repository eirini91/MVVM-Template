package com.televantou.template.ui.main

import com.televantou.template.data.DataManager
import com.televantou.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): MainViewModel {
        return MainViewModel(dataManager, schedulerProvider)
    }
}
