package com.example.user.test.presentation.screen.splash

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

class SplashActivity : BaseActivity(), SplashView {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, SplashActivity::class.java)
    }

    override val layoutId: Int = R.layout.activity_splash
    override val navigator: Navigator = SupportAppNavigator(this, R.id.flSplashContainer)

    @Inject
    lateinit var router: Router

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun provideSplashPresenter(): SplashPresenter = SplashPresenter(router)

    override fun onCreate(savedInstanceState: Bundle?) {
        MarvelApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        presenter.onFirstCreateCalled()
    }
}
