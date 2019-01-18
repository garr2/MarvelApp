package com.example.user.test.presentation.app

import android.app.Application
import com.example.user.test.presentation.inject.AppComponent
import com.example.user.test.presentation.inject.AppModule
import com.example.user.test.presentation.inject.DaggerAppComponent
import com.example.user.test.presentation.inject.UseCaseModule

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
            .useCaseModule(UseCaseModule())
            .build()
    }
}