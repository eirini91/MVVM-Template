package com.pkfcooperparry.template.ui.form.page;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class PageActivityModule {

    @Provides
    PageViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new PageViewModel(dataManager, schedulerProvider);
    }
}
