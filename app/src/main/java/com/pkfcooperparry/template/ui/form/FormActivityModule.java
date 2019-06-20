package com.pkfcooperparry.template.ui.form;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class FormActivityModule {

    @Provides
    FormViewModel provideVisitViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new FormViewModel(dataManager, schedulerProvider);
    }
}
