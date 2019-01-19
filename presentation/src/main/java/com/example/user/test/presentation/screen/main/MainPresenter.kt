package com.example.user.test.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.screen.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter(val router: Router) : BasePresenter<MainView>() {

    fun onBackPressed() = router.finishChain()

    fun setMainFragment() = router.navigateTo(Screens.MainFragmentScreen())
}