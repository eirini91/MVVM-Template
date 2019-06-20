package com.pkfcooperparry.template.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pkfcooperparry.template.data.AppDataManager;
import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.data.local.db.AppDbHelper;
import com.pkfcooperparry.template.data.local.db.DbHelper;
import com.pkfcooperparry.template.data.local.prefs.AppPreferencesHelper;
import com.pkfcooperparry.template.data.local.prefs.PreferencesHelper;
import com.pkfcooperparry.template.data.remote.ApiClient;
import com.pkfcooperparry.template.data.remote.ApiHeader;
import com.pkfcooperparry.template.data.remote.ApiHelper;
import com.pkfcooperparry.template.di.ApiInfo;
import com.pkfcooperparry.template.di.PreferenceInfo;
import com.pkfcooperparry.template.ui.custom.CustomDialog;
import com.pkfcooperparry.template.utils.AppConstants;
import com.pkfcooperparry.template.utils.Navigator;
import com.pkfcooperparry.template.utils.rx.AppSchedulerProvider;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiClient appApiHelper) {
        return appApiHelper.createService(ApiHelper.class);
    }

    @Provides
    @Singleton
    Realm provideAppDatabase() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides
    CustomDialog provideCustomDialog() {
        return new CustomDialog();
    }
//
//    @Provides
//    ViewGenerator provideViewGenerator(Context context) {
//        return new ViewGenerator(context);
//    }


}
