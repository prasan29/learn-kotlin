package com.learn_kotlin.model

data class Feed(
    val like: Boolean,
    val image: String?,
    val isSharable: Boolean,
    val comments: List<String>
)
