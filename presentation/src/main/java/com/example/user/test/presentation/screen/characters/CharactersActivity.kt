package com.example.user.test.presentation.screen.characters

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseActivity
import com.example.user.test.presentation.base.FlowNavigator
import com.example.user.test.presentation.base.FlowRouter
import com.example.user.test.presentation.screen.Screens
import com.example.user.test.presentation.screen.characters.characters.CharacterFragment
import com.example.user.test.presentation.screen.characters.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.characters.profile.ProfileFragment
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class CharactersActivity : BaseActivity<CharactersPresenter, FlowRouter>(), CharactersView {

    companion object {
        fun getInstance(mCtx: Context): Intent = Intent(mCtx, CharactersActivity::class.java)
    }

    init {
        MarvelApplication.appComponent.inject(this)
    }

    override val navigator: Navigator = object : FlowNavigator(this, R.id.tlFragmentContainer) {

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.CHARACTERS_SCREEN -> CharacterFragment()
            Screens.FAVORITE_SCREEN -> FavoriteFragment()
            Screens.PROFILE_SCREEN -> ProfileFragment()
            else -> null
        }

    }

    override val layoutId: Int = R.layout.activity_man

    @Inject
    @InjectPresenter
    lateinit var presenter: CharactersPresenter

    @ProvidePresenter
    fun provideCharactersPresenter(): CharactersPresenter = CharactersPresenter(router)

    override fun provideRouter(): FlowRouter {
        return MarvelApplication.instance.getRouter()
    }
}
