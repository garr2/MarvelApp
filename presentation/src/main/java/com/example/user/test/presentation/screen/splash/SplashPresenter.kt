package com.example.user.test.presentation.screen.splash

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.screen.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class SplashPresenter(
    private val router: Router
) : BasePresenter<SplashView>() {

    fun onFirstCreateCalled() = router.navigateTo(Screens.MainScreen())
}