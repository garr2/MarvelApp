package com.example.user.test.presentation.screen.main.mainFragment.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import com.example.user.test.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(val router: Router) : BasePresenter<ProfileView>(), MvpView