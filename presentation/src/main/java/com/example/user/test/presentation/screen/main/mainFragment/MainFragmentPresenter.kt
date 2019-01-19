package com.example.user.test.presentation.screen.main.mainFragment

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.screen.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class MainFragmentPresenter(var router: Router) : BasePresenter<MainFragmentView>()