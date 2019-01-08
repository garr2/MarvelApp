package com.example.user.test.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<P: BasePresenter<*,*>, R: BaseRouter<*>>: Fragment() {

    @InjectPresenter
    private lateinit var presenter: P

    private lateinit var router: R

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun provideLayoutId(): Int

    abstract fun providePresenter(router: R): P

    abstract fun provideRouter(): R

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(provideLayoutId(), container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router = provideRouter()
        presenter = providePresenter(router)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun addToDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }
}