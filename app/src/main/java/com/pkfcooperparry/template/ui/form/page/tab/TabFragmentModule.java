package com.pkfcooperparry.template.ui.form.page.tab;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class TabFragmentModule {

    @Provides
    TabFragmentViewModel providePageFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new TabFragmentViewModel(dataManager, schedulerProvider);
    }
}
