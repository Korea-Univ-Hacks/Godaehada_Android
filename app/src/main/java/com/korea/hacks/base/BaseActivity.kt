package com.korea.hacks.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB: ViewDataBinding> : AppCompatActivity() {

    protected abstract val layoutRes: Int
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        onDataBinding()
        setupView()
    }

    open fun onDataBinding() {
        binding.lifecycleOwner = this
    }

    open fun setupView() {

    }
}