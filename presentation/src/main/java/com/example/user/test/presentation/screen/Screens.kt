package com.example.user.test.presentation.screen

import android.content.Context
import android.content.Intent
import com.example.user.test.presentation.screen.main.MainActivity
import com.example.user.test.presentation.screen.splash.SplashActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    class SplashScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent {
            return SplashActivity.createIntent(context)
        }
    }

    class MainScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent {
            return MainActivity.createIntent(context)
        }
    }
}