package com.example.nikit.kotlintest.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nikit.kotlintest.BR
import com.example.nikit.kotlintest.BaseActivity
import com.example.nikit.kotlintest.R
import com.example.nikit.kotlintest.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.root.setOnClickListener {mainViewModel.loadAllUsers()}

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getVariableId(): Int {
        return BR.viewmodel
    }

    override fun getViewModel(): MainViewModel {
        return mainViewModel
    }

}
