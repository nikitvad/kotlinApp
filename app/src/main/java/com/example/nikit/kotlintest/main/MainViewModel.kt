package com.example.nikit.kotlintest.main

import android.databinding.Bindable
import android.util.Log
import com.example.nikit.kotlintest.BR
import com.example.nikit.kotlintest.BaseViewModel
import com.example.nikit.kotlintest.di.modules.Api
import com.example.nikit.kotlintest.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val api: Api) : BaseViewModel() {

    @Bindable
    var loading: Boolean = true

    override fun onBind() {
        loadAllUsers()
    }

    fun loadAllUsers() {
        addDisposable {
            api.getAllUsers()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        loading = true
                        notifyPropertyChanged(BR.loading)
                        Log.d("fsdfsdfsf0", "doOnSubscribe" + loading)
                    }
                    .doOnComplete {
                        loading = false
                        notifyPropertyChanged(BR.loading)
                        Log.d("fsdfsdfsf0", "doOnComplete" + loading)
                    }
                    .subscribe {
                        loading = false
                        notifyPropertyChanged(BR.loading)
                    }
        }
    }

}