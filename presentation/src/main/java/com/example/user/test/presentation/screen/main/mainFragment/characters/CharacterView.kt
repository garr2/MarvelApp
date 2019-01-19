package com.example.user.test.presentation.screen.main.mainFragment.characters

import com.arellomobile.mvp.MvpView
import com.example.domain.entity.Characters

interface CharacterView : MvpView{

    fun setList(list: List<Characters>)

    fun setTryAgainButtonVisibility(visibility: Int)

    fun showErrorMessage(t: Throwable)
}