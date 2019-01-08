package com.example.user.test.presentation.screen.splash

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.example.user.test.presentation.base.BasePresenter

@InjectViewState
class SplashPresenter(private val router: SplashRouter): BasePresenter<SplashView>() {

    fun changeActivity(){
        router.goToCharactersActivity()
    }

    init {
        Log.e("myLog", "SplashPresenter.init")
        //this.router?.goToCharacterFragment()
    }
}