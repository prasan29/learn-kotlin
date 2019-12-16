package com.learn_kotlin.util

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.learn_kotlin.base.BaseViewModel

class ViewModelBuilder private constructor() {
    fun <T : BaseViewModel?> buildViewModel(
        modelClass: Class<T>?,
        activity: FragmentActivity?
    ): T {
        return ViewModelProviders.of(activity!!)[modelClass!!]
    }

    companion object {
        val instance = ViewModelBuilder()
    }
}
