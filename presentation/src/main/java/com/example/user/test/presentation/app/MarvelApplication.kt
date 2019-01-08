package com.example.user.test.presentation.app

import android.app.Application

class MarvelApplication: Application() {

    companion object {
        lateinit var instance: MarvelApplication
    }

    init {
        instance = this
    }
}