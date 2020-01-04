package com.korea.hacks.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun Disposable.register() {
        compositeDisposable.add(this)
    }

    fun registerDisposables(vararg  disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}