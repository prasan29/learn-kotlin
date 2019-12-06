package com.learn_kotlin.viewmodel

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {
    fun onLikeClicked(view: View) {
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(view, "translationY", -100f, 0f)
        animator.setDuration(1000)
        animator.setInterpolator(BounceInterpolator())
        animator.repeatCount = 2
        animator.start()
    }
}
