package com.example.user.test.presentation.base

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

@InjectViewState
abstract class BasePresenter<V: BaseMVPView, R: BaseRouter<*>>(var router: R?): MvpPresenter<V>() {

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