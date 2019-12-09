package com.learn_kotlin.viewmodel

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.learn_kotlin.base.BaseViewModel
import com.learn_kotlin.model.Feed
import com.learn_kotlin.view.adapter.CardItemAdapter

class MainViewModel : BaseViewModel() {
    private val mTitle = MutableLiveData<String>()
    private lateinit var mActivity: Activity
    private lateinit var mLifecycleOwner: LifecycleOwner

    init {
        mTitle.value = "Hello"
    }

    fun getTitle(): MutableLiveData<String> = mTitle

    fun setComponents(activity: Activity, callback: (adapter: CardItemAdapter) -> Unit) {
        mActivity = activity
        mLifecycleOwner = activity as LifecycleOwner
        mTitle.observe(mLifecycleOwner, Observer { string ->
            Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show()
        })

        val list = mutableListOf<Feed>()
        list.add(0, Feed(true, null, true, listOf()))
        list.add(1, Feed(true, null, true, listOf()))
        list.add(2, Feed(true, null, true, listOf()))
        list.add(3, Feed(true, null, true, listOf()))
        list.add(4, Feed(true, null, true, listOf()))
        list.add(5, Feed(true, null, true, listOf()))
        list.add(6, Feed(true, null, true, listOf()))

        val adapter = CardItemAdapter(list, activity)

        callback(adapter)
    }


    fun onClick() {
        Toast.makeText(mActivity, "onClick", Toast.LENGTH_SHORT).show()
        mTitle.value = "Hi"
    }
}
