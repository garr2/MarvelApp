package com.example.user.test.presentation.screen.main.pageFragment

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.base.FlowRouter
import javax.inject.Inject

@InjectViewState
class PageFragmentPresenter @Inject constructor(private val router: FlowRouter) : BasePresenter<PageFragmentView>() {

    fun changeScreen(screenKey: String) {
        router.startFlow(screenKey)
    }
}