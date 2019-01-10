package com.example.user.test.presentation.screen.characters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseActivity
import com.example.user.test.presentation.base.BaseNavigator
import com.example.user.test.presentation.base.FlowRouter
import com.example.user.test.presentation.screen.Screens
import com.example.user.test.presentation.screen.characters.characters.CharacterFragment
import com.example.user.test.presentation.screen.characters.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.characters.profile.ProfileFragment
import ru.terrakok.cicerone.Navigator

class CharactersActivity : BaseActivity<CharactersPresenter, FlowRouter>(), CharactersView {

    companion object {
        fun getInstance(mCtx: Context): Intent = Intent(mCtx, CharactersActivity::class.java)
    }

    override val navigator: Navigator = object : BaseNavigator(this, R.id.tlFragmentContainer) {

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.CHARACTERS_SCREEN -> CharacterFragment()
            Screens.FAVORITE_SCREEN -> FavoriteFragment()
            Screens.PROFILE_SCREEN -> ProfileFragment()
            else -> null
        }

    }

    override val layoutId: Int = R.layout.activity_man

    @InjectPresenter
    lateinit var presenter: CharactersPresenter

    @ProvidePresenter
    fun provideCharactersPresenter(): CharactersPresenter = CharactersPresenter(router)

    override fun provideRouter(): FlowRouter {
        return MarvelApplication.instance.getRouter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
