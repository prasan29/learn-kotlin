package com.learn_kotlin.model

import android.graphics.Bitmap

data class Feed(
    val like: Boolean,
    val image: Bitmap?,
    val isSharable: Boolean,
    val comments: List<String>
)
