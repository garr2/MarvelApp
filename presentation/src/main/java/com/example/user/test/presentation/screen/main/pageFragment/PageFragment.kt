package com.example.user.test.presentation.screen.main.pageFragment

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.base.FlowRouter
import kotlinx.android.synthetic.main.page_fragment.*
import javax.inject.Inject

class PageFragment : BaseFragment<FlowRouter>(), PageFragmentView {

    companion object {
        fun getInstance(): PageFragment {
            return PageFragment()
        }
    }

    override val layoutId: Int = R.layout.page_fragment

    init {
        MarvelApplication.appComponent.inject(this)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: PageFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): PageFragmentPresenter {
        return PageFragmentPresenter(router)
    }

    override fun provideRouter(): FlowRouter {
        return MarvelApplication.instance.getRouter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vpFragmentPager.adapter = FragmentPagerAdapter(childFragmentManager)
        tlTabs.setupWithViewPager(vpFragmentPager)
    }
}