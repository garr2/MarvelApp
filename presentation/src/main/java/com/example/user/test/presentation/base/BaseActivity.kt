package com.example.user.test.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.user.test.presentation.app.MarvelApplication
import ru.terrakok.cicerone.Navigator

abstract class BaseActivity : MvpAppCompatActivity() {

    private val navigationHolder = MarvelApplication.instance.getNavigationHolder()

    protected abstract val navigator: Navigator
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()

        super.onPause()
    }
}