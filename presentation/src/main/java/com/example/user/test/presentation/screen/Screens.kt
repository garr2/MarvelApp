package com.example.user.test.presentation.screen

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.example.user.test.presentation.screen.main.MainActivity
import com.example.user.test.presentation.screen.main.pageFragment.MainFragment
import com.example.user.test.presentation.screen.main.pageFragment.characters.CharacterFragment
import com.example.user.test.presentation.screen.main.pageFragment.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.main.pageFragment.profile.ProfileFragment
import com.example.user.test.presentation.screen.splash.SplashActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    class SplashScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return SplashActivity.createIntent(context!!)
        }
    }

    class MainScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return MainActivity.createIntent(context!!)
        }
    }

    class PageScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = MainFragment()
    }

    class CharacterScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = CharacterFragment()
    }

    class FavoriteScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = FavoriteFragment()
    }

    class ProfileScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = ProfileFragment()
    }
}