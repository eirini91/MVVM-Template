package com.pkfcooperparry.template.ui.splash


import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider)
    }
}
