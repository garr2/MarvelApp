package com.example.user.test.presentation.screen.splash

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.base.BaseActivity

class SplashActivity : BaseActivity<SplashPresenter,SplashRouter>(),SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun provideSplashPresenter(): SplashPresenter{
        return SplashPresenter(router)
    }

    override fun provideLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun provideRouter(): SplashRouter {
       return SplashRouter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.changeActivity()

    }


}
