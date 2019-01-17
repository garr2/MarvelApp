package com.example.user.test.presentation.screen.main.mainFragment.favorite

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class FavoritePresenter @Inject constructor(val router: Router) : BasePresenter<FavoriteView>(), FavoriteView