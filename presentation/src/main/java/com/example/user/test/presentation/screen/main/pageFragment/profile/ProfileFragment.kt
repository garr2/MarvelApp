package com.example.user.test.presentation.screen.main.pageFragment.profile

import com.example.user.test.R
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.base.FlowRouter

class ProfileFragment : BaseFragment<FlowRouter>() {

    companion object {
        fun getInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override val layoutId: Int = R.layout.profile_fragment

    override fun provideRouter(): FlowRouter {
        return FlowRouter()
    }
}