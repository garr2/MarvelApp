package com.example.user.test.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpPresenter
import com.example.user.test.presentation.app.MarvelApplication
import ru.terrakok.cicerone.Navigator

abstract class BaseActivity<P : MvpPresenter<*>, R : FlowRouter> : MvpAppCompatActivity() {

    protected val router: R

    val navigationHolder = MarvelApplication.instance.getNavigationHolder()

    protected abstract val navigator: Navigator
    protected abstract val layoutId: Int

    init {
        router = provideRouter()
    }

    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
    }

    override fun onResume() {
        super.onResume()

        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()

        super.onPause()
    }
}