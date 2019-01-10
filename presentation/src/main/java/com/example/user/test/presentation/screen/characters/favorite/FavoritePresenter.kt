package com.example.user.test.presentation.screen.characters.favorite

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.base.FlowRouter

@InjectViewState
class FavoritePresenter(val router: FlowRouter) : BasePresenter<FavoriteView>(), FavoriteView {

}