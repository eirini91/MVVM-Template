package com.televantou.template.ui.form.page

import com.televantou.template.data.DataManager
import com.televantou.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class PageActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): PageViewModel {
        return PageViewModel(dataManager, schedulerProvider)
    }
}
