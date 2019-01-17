package com.example.user.test.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(val router: Router) : BasePresenter<MainView>() {

    fun onBackPressed() = router.finishChain()
}