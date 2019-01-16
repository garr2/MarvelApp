package com.example.user.test.presentation.inject

import com.example.user.test.presentation.screen.main.mainFragment.MainFragmentPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class AppModule {

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    fun provideMainFragmentPresenter(router: Router): MainFragmentPresenter = MainFragmentPresenter(router)

    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()
}