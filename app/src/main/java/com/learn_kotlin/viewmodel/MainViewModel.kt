package com.learn_kotlin.viewmodel

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.learn_kotlin.base.BaseViewModel
import com.learn_kotlin.model.Feed
import com.learn_kotlin.view.adapter.CardItemAdapter

class MainViewModel : BaseViewModel() {
    private lateinit var mActivity: Activity
    private lateinit var mLifecycleOwner: LifecycleOwner

    fun setComponents(
        activity: FragmentActivity,
        callback: (adapter: CardItemAdapter) -> Unit,
        cardViewModel: CardViewModel
    ) {
        mActivity = activity
        mLifecycleOwner = activity

        val list = mutableListOf<Feed>()

        list.apply {
            add(0, Feed(true, null, true, listOf()))
            add(1, Feed(true, null, true, listOf()))
            add(2, Feed(true, null, true, listOf()))
            add(3, Feed(true, null, true, listOf()))
            add(4, Feed(true, null, true, listOf()))
            add(5, Feed(true, null, true, listOf()))
            add(6, Feed(true, null, true, listOf()))
        }

        callback(
            CardItemAdapter(
                list,
                activity,
                cardViewModel
            )
        )
    }
}
