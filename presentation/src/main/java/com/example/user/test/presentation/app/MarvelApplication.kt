package com.example.user.test.presentation.app

import android.app.Application
import com.example.user.test.presentation.inject.AppComponent
import com.example.user.test.presentation.inject.AppModule
import com.example.user.test.presentation.inject.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class MarvelApplication : Application() {

    companion object {
        lateinit var instance: MarvelApplication
            private set
        lateinit var appComponent: AppComponent
            private set
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
    }
}