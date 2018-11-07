package com.example.nikit.kotlintest.main

import com.example.nikit.kotlintest.di.modules.Api
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{

    @Provides
    fun provideMainViewModel(api: Api):MainViewModel{
        return MainViewModel(api)
    }
}
