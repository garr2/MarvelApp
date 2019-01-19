package com.example.user.test.presentation.screen

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.example.user.test.presentation.screen.main.MainActivity
import com.example.user.test.presentation.screen.main.mainFragment.MainFragment
import com.example.user.test.presentation.screen.main.mainFragment.characters.CharacterFragment
import com.example.user.test.presentation.screen.main.mainFragment.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.main.mainFragment.profile.ProfileFragment
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

    class MainFragmentScreen : SupportAppScreen() {
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