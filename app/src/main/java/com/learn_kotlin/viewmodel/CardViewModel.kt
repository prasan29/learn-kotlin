package com.learn_kotlin.viewmodel

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.learn_kotlin.base.BaseViewModel
import com.learn_kotlin.util.LoggerUtils

class CardViewModel(mActivity: FragmentActivity) : BaseViewModel() {
    private val mIsLikeClicked: MutableLiveData<Boolean> = MutableLiveData()
    private val TAG: String = "DEBUG_CardViewModel"

    init {
        mIsLikeClicked.value = false
        mIsLikeClicked.observe(mActivity, Observer {
            LoggerUtils.logVerbose(TAG, "" + it)
        })
    }

    fun getIsClicked(): MutableLiveData<Boolean> {
        return mIsLikeClicked
    }

    fun onLikeClicked(view: View) {
        /*val animator: ObjectAnimator = ObjectAnimator.ofFloat(view, "translationY", -52f, 0f)
        animator.duration = 500
        animator.interpolator = BounceInterpolator()
        animator.start()*/
        if (mIsLikeClicked.value == true) {
            mIsLikeClicked.value = false
        } else {
            mIsLikeClicked.value = true
        }
    }
}
