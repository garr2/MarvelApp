package com.example.user.test.presentation.screen.characters.favorite

import com.example.user.test.R
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.base.FlowRouter

class FavoriteFragment : BaseFragment<FlowRouter>() {


    override fun layoutId(): Int = R.layout.favorite_fragment

    override fun provideRouter(): FlowRouter {
        return FlowRouter()
    }
}