package com.example.user.test.presentation.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageUrl(url: String) {
    Glide.with(this.context).setDefaultRequestOptions(RequestOptions().fitCenter().circleCrop())
        .load(url).into(this)
}