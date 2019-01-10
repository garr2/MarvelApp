package com.example.user.test.presentation.screen.characters.profile

import com.example.user.test.R
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.base.FlowRouter

class ProfileFragment : BaseFragment<FlowRouter>() {


    override fun layoutId(): Int = R.layout.profile_fragment

    override fun provideRouter(): FlowRouter {
        return FlowRouter()
    }
}