package com.example.user.test.presentation.screen.main.pageFragment.favorite

import com.example.user.test.R
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.base.FlowRouter

class FavoriteFragment : BaseFragment<FlowRouter>() {

    companion object {
        fun getInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }

    override val layoutId: Int = R.layout.favorite_fragment

    override fun provideRouter(): FlowRouter {
        return FlowRouter()
    }
}