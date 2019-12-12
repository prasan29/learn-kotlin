package com.learn_kotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.learn_kotlin.R
import com.learn_kotlin.databinding.ActivityMainBinding
import com.learn_kotlin.util.ViewModelBuilderJ
import com.learn_kotlin.viewmodel.CardViewModel
import com.learn_kotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mCardViewModel: CardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        buildViewModels()

        mMainViewModel.setComponents(this, {
            binding.adapter = it
        }, mCardViewModel)

        binding.lifecycleOwner = this
        binding.viewModel = mMainViewModel
    }

    private fun buildViewModels() {
        mMainViewModel =
            ViewModelBuilderJ.instance.buildViewModel(MainViewModel::class.java, this)
        mCardViewModel =
            ViewModelBuilderJ.instance.buildViewModel(CardViewModel::class.java, this)
    }
}
