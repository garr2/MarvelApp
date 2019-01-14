package com.example.user.test.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment<R : FlowRouter> : MvpAppCompatFragment() {

    protected lateinit var router: R

    protected abstract val layoutId: Int

    init {
        router = provideRouter()
    }

    abstract fun provideRouter(): R

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layoutId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}