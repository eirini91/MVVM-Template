package com.televantou.template.ui.form.page.tab

import com.televantou.template.data.DataManager
import com.televantou.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class TabFragmentModule {

    @Provides
    internal fun providePageFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): TabFragmentViewModel {
        return TabFragmentViewModel(dataManager, schedulerProvider)
    }
}
