package com.example.nikit.kotlintest.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule{

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit):Api{
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory,
                        callAdapterFactory: CallAdapter.Factory,
                        okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

    }

    @Provides
    @Singleton
    fun provideGson():GsonConverterFactory{
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    fun provideCallAdapterFactory():CallAdapter.Factory{
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .cache(null)
                .build()
    }

    @Provides
    @Singleton
    fun provideLoginingInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}