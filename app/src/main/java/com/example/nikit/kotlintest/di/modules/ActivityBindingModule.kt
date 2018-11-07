package com.example.nikit.kotlintest.di.modules

import com.example.nikit.kotlintest.main.MainActivity
import com.example.nikit.kotlintest.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity():MainActivity
}