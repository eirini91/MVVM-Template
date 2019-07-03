package com.pkfcooperparry.template.ui.form.page.tab

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class TabFragmentModule {

    @Provides
    internal fun providePageFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): TabFragmentViewModel {
        return TabFragmentViewModel(dataManager, schedulerProvider)
    }
}
