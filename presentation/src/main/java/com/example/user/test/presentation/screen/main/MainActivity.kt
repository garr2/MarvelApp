package com.example.user.test.presentation.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override val navigator: Navigator = SupportAppNavigator(this, R.id.flMainContainer)

    override val layoutId: Int = R.layout.activity_main

    @Inject
    lateinit var router: Router

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun provideCharactersPresenter(): MainPresenter = MainPresenter(router)

    override fun onCreate(savedInstanceState: Bundle?) {
        MarvelApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
       presenter.onBackPressed()
    }
}