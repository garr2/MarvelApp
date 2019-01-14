package com.example.user.test.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.base.FlowRouter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(val router: FlowRouter) : BasePresenter<MainView>() {
}