package com.example.user.test.presentation.screen.characters.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.base.FlowRouter

@InjectViewState
class ProfilePresenter(val router: FlowRouter) : BasePresenter<ProfileView>(), MvpView {
}