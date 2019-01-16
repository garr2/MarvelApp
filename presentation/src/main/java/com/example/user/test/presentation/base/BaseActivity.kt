package com.example.user.test.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.user.test.presentation.app.MarvelApplication
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navigationHolder : NavigatorHolder

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