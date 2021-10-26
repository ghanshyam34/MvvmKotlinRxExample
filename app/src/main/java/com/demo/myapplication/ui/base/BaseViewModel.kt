package com.demo.myapplication.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
/*
  created by Ghanshyam
 */
abstract class BaseViewModel<N: Any> : ViewModel() {
    protected val disposable = CompositeDisposable()
    var navigator: N? = null
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}