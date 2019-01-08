package com.example.user.test.presentation.base

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V: MvpView>: MvpPresenter<V>() {

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun addToDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}