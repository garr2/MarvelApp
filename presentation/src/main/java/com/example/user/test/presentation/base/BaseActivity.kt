package com.example.user.test.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity<P: MvpPresenter<*>, R: BaseRouter<*>>: MvpAppCompatActivity() {

    protected val router: R

    init {
        router = provideRouter()
    }

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun provideLayoutId(): Int

    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("myLog", "CharactersActivity.onCreate")
        setContentView(provideLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun addToDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }
}