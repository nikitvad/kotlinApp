package com.example.nikit.kotlintest

import android.databinding.BaseObservable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel:BaseObservable(){
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: () -> Disposable){
        compositeDisposable.add(disposable.invoke())
    }

    abstract fun onBind()

    fun onUnbind(){
        compositeDisposable.clear()
    }
}