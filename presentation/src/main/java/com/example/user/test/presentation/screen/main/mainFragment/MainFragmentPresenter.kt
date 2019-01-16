package com.example.user.test.presentation.screen.main.mainFragment

import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.screen.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class MainFragmentPresenter(var router: Router) : BasePresenter<MainFragmentView>() {

    fun setProfileFragment() {
        router.navigateTo(Screens.ProfileScreen())
    }

    fun setFavoritesFragment() {
        router.navigateTo(Screens.FavoriteScreen())
    }

    fun setCharacterFragment() {
        router.navigateTo(Screens.CharacterScreen())
    }

}