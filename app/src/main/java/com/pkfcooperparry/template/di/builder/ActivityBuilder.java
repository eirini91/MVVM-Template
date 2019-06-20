package com.pkfcooperparry.template.di.builder;


import com.pkfcooperparry.template.ui.form.FormActivity;
import com.pkfcooperparry.template.ui.form.FormActivityModule;
import com.pkfcooperparry.template.ui.form.page.PageActivity;
import com.pkfcooperparry.template.ui.form.page.PageActivityModule;
import com.pkfcooperparry.template.ui.form.page.tab.TabFragmentProvider;
import com.pkfcooperparry.template.ui.login.LoginActivity;
import com.pkfcooperparry.template.ui.login.LoginActivityModule;
import com.pkfcooperparry.template.ui.main.MainActivity;
import com.pkfcooperparry.template.ui.main.MainActivityModule;
import com.pkfcooperparry.template.ui.splash.SplashActivity;
import com.pkfcooperparry.template.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();


    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {PageActivityModule.class, TabFragmentProvider.class})
    abstract PageActivity bindFormActivity();


    @ContributesAndroidInjector(modules = FormActivityModule.class)
    abstract FormActivity bindVisitActivity();
}
