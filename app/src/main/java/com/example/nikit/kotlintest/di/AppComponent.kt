package com.example.nikit.kotlintest.di

import com.example.nikit.kotlintest.App
import com.example.nikit.kotlintest.di.modules.ActivityBindingModule
import com.example.nikit.kotlintest.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    RetrofitModule::class,
    ActivityBindingModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: android.app.Application): Builder

        fun build(): AppComponent
    }
}