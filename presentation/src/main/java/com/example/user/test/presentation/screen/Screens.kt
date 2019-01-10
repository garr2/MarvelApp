package com.example.user.test.presentation.screen

import android.content.Context
import android.content.Intent
import com.example.user.test.presentation.screen.characters.CharactersActivity
import com.example.user.test.presentation.screen.splash.SplashActivity

object Screens {

    const val SPLASH_FLOW = "splash_flow"

    const val CHARACTERS_FLOW = "characters_flow"
    const val CHARACTERS_SCREEN = "characters_screen"
    const val FAVORITE_SCREEN = "favorite_screen"
    const val PROFILE_SCREEN = "profile_screen"

    fun getFlowIntent(context: Context, flowKey: String, data: Any?): Intent? {
        return when (flowKey) {
            Screens.SPLASH_FLOW -> SplashActivity.getInstance(context)
            Screens.CHARACTERS_FLOW -> CharactersActivity.getInstance(context)
            else -> null

        }
    }
}