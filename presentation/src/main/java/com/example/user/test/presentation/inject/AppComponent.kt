package com.example.user.test.presentation.inject

import com.example.user.test.presentation.screen.main.MainActivity
import com.example.user.test.presentation.screen.main.mainFragment.MainFragment
import com.example.user.test.presentation.screen.main.mainFragment.characters.CharacterFragment
import com.example.user.test.presentation.screen.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UseCaseModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)
    fun inject(fragment: MainFragment)
    fun inject(fragment: CharacterFragment)
}