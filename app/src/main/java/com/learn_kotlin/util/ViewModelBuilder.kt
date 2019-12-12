package com.learn_kotlin.util

class ViewModelBuilder {
    companion object {
        private lateinit var viewModelBuilder: ViewModelBuilder
        fun getInstance(): ViewModelBuilder {
            return viewModelBuilder
        }
    }
}
