package com.example.user.test.presentation.app

import android.app.Application
import com.example.user.test.presentation.base.FlowRouter
import com.example.user.test.presentation.inject.AppComponent
import com.example.user.test.presentation.inject.AppModule
import com.example.user.test.presentation.inject.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

class MarvelApplication : Application() {

    private val router = FlowRouter()
    private val cicerone: Cicerone<FlowRouter> = Cicerone.create(router)


    companion object {
        lateinit var instance: MarvelApplication
        lateinit var appComponent: AppComponent
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

    fun getNavigationHolder(): NavigatorHolder = cicerone.navigatorHolder

    fun getRouter(): FlowRouter = cicerone.router
}