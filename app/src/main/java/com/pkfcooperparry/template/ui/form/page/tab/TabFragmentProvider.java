package com.pkfcooperparry.template.ui.form.page.tab;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TabFragmentProvider {

    @ContributesAndroidInjector(modules = TabFragmentModule.class)
    abstract TabFragment provideStatsFragmentFactory();
}
