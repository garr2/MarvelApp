package com.example.user.test.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.screen.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(val router: Router) : BasePresenter<MainView>() {

    fun onBackPressed() = router.exit()

    fun setPageFragment() = router.navigateTo(Screens.PageScreen())
}