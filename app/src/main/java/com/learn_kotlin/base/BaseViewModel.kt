package com.learn_kotlin.base

import androidx.lifecycle.ViewModel
import com.learn_kotlin.util.LoggerUtils

open class BaseViewModel : ViewModel() {
    private var TAG: String = "BaseViewModel"

    override fun onCleared() {
        super.onCleared()
        LoggerUtils.logVerbose(TAG, "onCleared()")
    }
}