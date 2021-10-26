package com.demo.myapplication.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/*
 created by Ghanshyam
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(){

     var viewDataBinding: T? = null
    private var mViewModel: V? = null
    abstract val bindingVariable: Int
    @get:LayoutRes
    abstract val layoutId: Int
    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        init()
    }

    internal fun init() {
        performDataBinding()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        this.mViewModel = if (mViewModel == null) viewModel else mViewModel
        viewDataBinding!!.setVariable(bindingVariable, mViewModel)
        viewDataBinding!!.executePendingBindings()
    }

    var progress: ProgressDialog? = null
    open fun showProgress() {
        try {
            if (progress == null) progress = ProgressDialog(this)
            progress!!.setMessage("Please Wait..")
            progress!!.setCancelable(false)
            progress!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
            try {
                progress = ProgressDialog(this)
                progress!!.setMessage("Please Wait..")
                progress!!.setCancelable(false)
                progress!!.show()
            } catch (e2: Exception) {
                e2.printStackTrace()
            }
        }
    }


    open fun hideProgress() {
        if (progress != null && progress!!.isShowing) {
            progress!!.dismiss()
        }
    }
}

