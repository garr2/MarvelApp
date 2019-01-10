package com.example.user.test.presentation.app

import android.app.Application
import com.example.user.test.presentation.base.FlowRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

class MarvelApplication : Application() {

    private val router = FlowRouter()
    private val cicerone: Cicerone<FlowRouter> = Cicerone.create(router)

    companion object {
        lateinit var instance: MarvelApplication
    }

    init {
        instance = this
    }

    fun getNavigationHolder(): NavigatorHolder = cicerone.navigatorHolder

    fun getRouter(): FlowRouter = cicerone.router
}