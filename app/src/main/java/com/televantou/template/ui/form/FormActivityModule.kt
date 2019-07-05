package com.televantou.template.ui.form

import com.televantou.template.data.DataManager
import com.televantou.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class FormActivityModule {

    @Provides
    internal fun provideVisitViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): FormViewModel {
        return FormViewModel(dataManager, schedulerProvider)
    }
}
