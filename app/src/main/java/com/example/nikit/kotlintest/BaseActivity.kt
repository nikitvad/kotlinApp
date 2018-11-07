package com.example.nikit.kotlintest

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<V : ViewDataBinding, M : BaseViewModel> : DaggerAppCompatActivity() {
   lateinit var viewBinding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        if (getVariableId() >= 0) {
            viewBinding.setVariable(getVariableId(), getViewModel())
        }
        viewBinding.executePendingBindings()
        getViewModel()?.onBind()
    }

    override fun onStop() {
        super.onStop()
        getViewModel()?.onUnbind()
    }

    abstract fun getVariableId(): Int

    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): M?

}