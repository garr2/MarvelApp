package com.example.user.test.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity<P: BasePresenter<*,*>, R: BaseRouter<*>>: AppCompatActivity() {

    @InjectPresenter
    private lateinit var presenter: P

    private lateinit var router: R

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun provideLayoutId(): Int

    abstract fun providePresenter(router: R): P

    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(provideLayoutId())
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