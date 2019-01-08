package com.example.user.test.presentation.screen.splash

import android.content.Intent
import com.example.user.test.presentation.base.BaseRouter
import com.example.user.test.presentation.screen.man.CharactersActivity

class SplashRouter(activity: SplashActivity): BaseRouter<SplashActivity>(activity) {

    fun goToCharactersActivity(){
        activity.startActivity(Intent(activity,CharactersActivity::class.java))
    }
}