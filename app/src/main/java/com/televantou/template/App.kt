package com.televantou.template

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.televantou.template.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    private var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
        @Inject set

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)


    }
}
