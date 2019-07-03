package com.pkfcooperparry.template.ui.form.page

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class PageActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): PageViewModel {
        return PageViewModel(dataManager, schedulerProvider)
    }
}
