package com.example.user.test.presentation.screen.main.mainFragment.characters

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CharacterPresenter @Inject constructor(val router: Router) : BasePresenter<CharacterView>()