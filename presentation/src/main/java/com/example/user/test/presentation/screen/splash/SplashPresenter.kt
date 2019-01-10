package com.example.user.test.presentation.screen.splash

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.base.FlowRouter
import com.example.user.test.presentation.screen.Screens

@InjectViewState
class SplashPresenter(private val router: FlowRouter) : BasePresenter<SplashView>() {

    fun changeActivity() {
        router.startFlow(Screens.CHARACTERS_FLOW)
    }
}