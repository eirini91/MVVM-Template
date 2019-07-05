package com.televantou.template.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.televantou.template.data.AppDataManager
import com.televantou.template.data.DataManager
import com.televantou.template.data.local.db.AppDbHelper
import com.televantou.template.data.local.db.DbHelper
import com.televantou.template.data.local.prefs.AppPreferencesHelper
import com.televantou.template.data.local.prefs.PreferencesHelper
import com.televantou.template.data.remote.ApiClient
import com.televantou.template.data.remote.ApiHeader
import com.televantou.template.data.remote.ApiHelper
import com.televantou.template.di.ApiInfo
import com.televantou.template.di.PreferenceInfo
import com.televantou.template.ui.custom.CustomDialog
import com.televantou.template.utils.AppConstants
import com.televantou.template.utils.Navigator
import com.televantou.template.utils.rx.AppSchedulerProvider
import com.televantou.template.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: ApiClient): ApiHelper {
        return appApiHelper.createService(ApiHelper::class.java)
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiInfo apiKey: String,
                                           preferencesHelper: PreferencesHelper): ApiHeader.ProtectedApiHeader {
        return ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.currentUserId,
                preferencesHelper.accessToken)
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    internal fun provideNavigator(): Navigator {
        return Navigator()
    }

    @Provides
    internal fun provideCustomDialog(): CustomDialog {
        return CustomDialog()
    }
    //
    //    @Provides
    //    ViewGenerator provideViewGenerator(Context context) {
    //        return new ViewGenerator(context);
    //    }


}
