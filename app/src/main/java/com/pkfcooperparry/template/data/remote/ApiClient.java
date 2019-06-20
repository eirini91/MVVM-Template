package com.pkfcooperparry.template.data.remote;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Singleton
public class ApiClient {
    public static final String BASE_URL = "https://testapp.azurewebsites.net/Api/";

    public static final String HEADER_ACCEPT_JSON = "Accept: application/json";
    public static final String HEADER_CONTENT_TYPE_JSON = "Content-Type: application/json";
    private Retrofit.Builder retrofitBuilder;

    @Inject
    public ApiClient() {

        this(new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonCustomConverterFactory.create(
                        new GsonBuilder()
                                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                                .create()
                ))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()));
    }

    public ApiClient(Retrofit.Builder retrofitBuilder) {
        this.retrofitBuilder = retrofitBuilder;
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofitBuilder.build().create(serviceClass);
    }

    public static class GsonCustomConverterFactory extends Converter.Factory {
        private final Gson gson;
        private final GsonConverterFactory gsonConverterFactory;

        private GsonCustomConverterFactory(Gson gson) {
            if (gson == null) throw new NullPointerException("gson == null");
            this.gson = gson;
            this.gsonConverterFactory = GsonConverterFactory.create(gson);
        }

        public static GsonCustomConverterFactory create(Gson gson) {
            return new GsonCustomConverterFactory(gson);
        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(
                Type type, Annotation[] annotations, Retrofit retrofit) {
            if (type.equals(String.class)) {
                return new GsonResponseBodyConverterToString<>(gson, type);
            } else {
                return gsonConverterFactory.responseBodyConverter(type, annotations, retrofit);
            }
        }

        @Override
        public Converter<?, RequestBody> requestBodyConverter(
                Type type,
                Annotation[] parameterAnnotations,
                Annotation[] methodAnnotations,
                Retrofit retrofit) {
            return gsonConverterFactory.requestBodyConverter(
                    type, parameterAnnotations, methodAnnotations, retrofit);
        }
    }

    /**
     * This wrapper is to take care of this case:
     * when the deserialization fails due to JsonParseException and the
     * expected type is String, then just return the body string.
     */
    public static class GsonResponseBodyConverterToString<T> implements
            Converter<ResponseBody, T> {
        private final Gson gson;
        private final Type type;

        GsonResponseBodyConverterToString(Gson gson, Type type) {
            this.gson = gson;
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T convert(@NonNull ResponseBody value) throws IOException {
            String returned = value.string();
            try {
                return gson.fromJson(returned, type);
            } catch (JsonParseException e) {
                return (T) returned;
            }
        }
    }


}
