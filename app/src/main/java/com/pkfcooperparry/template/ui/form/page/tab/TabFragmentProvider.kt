package com.pkfcooperparry.template.ui.form.page.tab

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TabFragmentProvider {

    @ContributesAndroidInjector(modules = [TabFragmentModule::class])
    internal abstract fun provideStatsFragmentFactory(): TabFragment
}
