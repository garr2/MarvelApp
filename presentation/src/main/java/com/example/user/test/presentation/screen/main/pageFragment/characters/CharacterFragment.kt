package com.example.user.test.presentation.screen.main.pageFragment.characters

import android.os.Bundle
import android.view.View
import com.example.user.test.R
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.base.FlowRouter

class CharacterFragment : BaseFragment<FlowRouter>() {

    companion object {
        fun getInstance(): CharacterFragment {
            return CharacterFragment()
        }
    }

    override val layoutId: Int = R.layout.characters_fragment

    override fun provideRouter(): FlowRouter {
        return FlowRouter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }
}