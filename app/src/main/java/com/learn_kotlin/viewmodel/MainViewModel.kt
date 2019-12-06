package com.learn_kotlin.viewmodel

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val mTitle = MutableLiveData<String>()
    private lateinit var mActivity: Activity
    private lateinit var mLifecycleOwner: LifecycleOwner

    init {
        mTitle.value = "Hello"
    }

    fun getTitle(): MutableLiveData<String> = mTitle

    fun setComponents(activity: Activity) {
        mActivity = activity
        mLifecycleOwner = activity as LifecycleOwner
        mTitle.observe(mLifecycleOwner, Observer { string ->
            Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show()
        })
    }


    fun onClick() {
        Toast.makeText(mActivity, "onClick", Toast.LENGTH_SHORT).show()
        mTitle.value = "Hi"
    }
}
