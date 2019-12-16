package com.learn_kotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.learn_kotlin.R
import com.learn_kotlin.databinding.ActivityMainBinding
import com.learn_kotlin.util.ViewModelBuilderJ
import com.learn_kotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        buildViewModels()

        mMainViewModel.setComponents(this) {
            binding.adapter = it
        }

        binding.lifecycleOwner = this
        binding.viewModel = mMainViewModel
    }

    private fun buildViewModels() {
        mMainViewModel =
            ViewModelBuilderJ.instance.buildViewModel(MainViewModel::class.java, this)
    }
}
