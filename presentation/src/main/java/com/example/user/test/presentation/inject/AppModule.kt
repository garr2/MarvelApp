package com.example.user.test.presentation.inject

import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.holder.LocalCiceroneHolder
import com.example.user.test.presentation.screen.main.mainFragment.MainFragmentPresenter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class AppModule {

    @Provides
    fun provideCicerone(): Router = MarvelApplication.instance.getRouter()

    @Provides
    fun provideLocalCiceroneHolder(): LocalCiceroneHolder = LocalCiceroneHolder()

    @Provides
    fun provideMainFragmentPresenter(router: Router): MainFragmentPresenter = MainFragmentPresenter(router)
}