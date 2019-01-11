package com.example.user.test.presentation.screen.splash

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
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashPresenter, FlowRouter>(), SplashView {

    companion object {
        fun getInstance(mCtx: Context): Intent = Intent(mCtx, SplashActivity::class.java)

        const val SPLASH_ACTIVITY_REQUEST_CODE = 1
    }

    init {
        MarvelApplication.appComponent.inject(this)
    }

    override val layoutId: Int = R.layout.activity_splash
    override val navigator: Navigator = object : FlowNavigator(this, R.id.flStub) {
        override fun createFragment(screenKey: String?, data: Any?): Fragment? {
            return null
        }

        override fun createFlowIntent(flowKey: String, data: Any?): Intent? {
            return Screens.getFlowIntent(this@SplashActivity, flowKey, data)
        }

        override fun getRequestCodeForFlow(flowKey: String): Int {
            return SPLASH_ACTIVITY_REQUEST_CODE
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun provideSplashPresenter(): SplashPresenter = SplashPresenter(router)

    override fun provideRouter(): FlowRouter {
        return MarvelApplication.instance.getRouter()
    }

    override fun onResume() {
        super.onResume()

        presenter.changeActivity()
    }
}
