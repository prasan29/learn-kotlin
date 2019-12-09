package com.learn_kotlin.viewmodel

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.lifecycle.MutableLiveData
import com.learn_kotlin.base.BaseViewModel

class CardViewModel : BaseViewModel() {
    private val mIsLikeClicked: MutableLiveData<Boolean> = MutableLiveData()

    init {
        mIsLikeClicked.value = false
    }

    fun getIsClicked(): MutableLiveData<Boolean> {
        return mIsLikeClicked
    }

    fun onLikeClicked(view: View) {
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(view, "translationY", -52f, 0f)
        animator.duration = 500
        animator.interpolator = BounceInterpolator()
        animator.start()

        mIsLikeClicked.value = true
    }
}
