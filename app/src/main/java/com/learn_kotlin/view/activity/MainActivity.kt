package com.learn_kotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.learn_kotlin.R
import com.learn_kotlin.databinding.ActivityMainBinding
import com.learn_kotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.setComponents(this) { adapter ->
            binding.adapter = adapter
        }
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
