package com.televantou.template.ui.splash


import com.televantou.template.data.DataManager
import com.televantou.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider)
    }
}
