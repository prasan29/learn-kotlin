package com.learn_kotlin.model

data class Feed(
    var like: Boolean,
    var image: String?,
    var numberOfLikes: Int,
    var numberOfComments: Int,
    val isSharable: Boolean,
    val comments: List<String>
)
