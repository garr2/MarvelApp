package com.example.user.test.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<R : FlowRouter> : Fragment() {

    private lateinit var router: R

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun layoutId(): Int

    abstract fun provideRouter(): R

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router = provideRouter()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}