package com.televantou.template.di.builder


import com.televantou.template.ui.form.FormActivity
import com.televantou.template.ui.form.FormActivityModule
import com.televantou.template.ui.form.page.PageActivity
import com.televantou.template.ui.form.page.PageActivityModule
import com.televantou.template.ui.form.page.tab.TabFragmentProvider
import com.televantou.template.ui.login.LoginActivity
import com.televantou.template.ui.login.LoginActivityModule
import com.televantou.template.ui.main.MainActivity
import com.televantou.template.ui.main.MainActivityModule
import com.televantou.template.ui.splash.SplashActivity
import com.televantou.template.ui.splash.SplashActivityModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity


    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [PageActivityModule::class, TabFragmentProvider::class])
    internal abstract fun bindFormActivity(): PageActivity


    @ContributesAndroidInjector(modules = [FormActivityModule::class])
    internal abstract fun bindVisitActivity(): FormActivity
}
