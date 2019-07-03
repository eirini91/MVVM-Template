package com.pkfcooperparry.template.ui.form

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class FormActivityModule {

    @Provides
    internal fun provideVisitViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): FormViewModel {
        return FormViewModel(dataManager, schedulerProvider)
    }
}
