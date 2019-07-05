package com.televantou.template.data.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient(private val retrofitBuilder: Retrofit.Builder) {

    @Inject
    constructor() : this(Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(
                    GsonBuilder()
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                            .create()
            ))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()))

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofitBuilder.build().create(serviceClass)
    }

    companion object {
        const val BASE_URL = "https://testapp.azurewebsites.net/Api/"
        const val HEADER_ACCEPT_JSON = "Accept: application/json"
        const val HEADER_CONTENT_TYPE_JSON = "Content-Type: application/json"
    }


}
