package com.example.user.test.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpPresenter
import com.example.user.test.presentation.app.MarvelApplication
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Navigator

abstract class BaseActivity<P : MvpPresenter<*>, R : FlowRouter> : MvpAppCompatActivity() {

    protected val router: R

    val navigationHolder = MarvelApplication.instance.getNavigationHolder()

    protected abstract val navigator: Navigator
    protected abstract val layoutId: Int

    init {
        router = provideRouter()
    }

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onResume() {
        super.onResume()

        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}