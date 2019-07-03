package com.pkfcooperparry.template.di.builder


import com.pkfcooperparry.template.ui.form.FormActivity
import com.pkfcooperparry.template.ui.form.FormActivityModule
import com.pkfcooperparry.template.ui.form.page.PageActivity
import com.pkfcooperparry.template.ui.form.page.PageActivityModule
import com.pkfcooperparry.template.ui.form.page.tab.TabFragmentProvider
import com.pkfcooperparry.template.ui.login.LoginActivity
import com.pkfcooperparry.template.ui.login.LoginActivityModule
import com.pkfcooperparry.template.ui.main.MainActivity
import com.pkfcooperparry.template.ui.main.MainActivityModule
import com.pkfcooperparry.template.ui.splash.SplashActivity
import com.pkfcooperparry.template.ui.splash.SplashActivityModule

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
