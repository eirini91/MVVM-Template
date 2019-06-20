package com.pkfcooperparry.template.di.component;

import android.app.Application;

import com.pkfcooperparry.template.App;
import com.pkfcooperparry.template.di.builder.ActivityBuilder;
import com.pkfcooperparry.template.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class})

public interface AppComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}