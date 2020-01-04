package com.korea.hacks.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB: ViewDataBinding>: Fragment() {
    protected abstract val layoutRes: Int
    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        onDataBinding()
        setupView()
        return binding.root
    }

    open fun onDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    open fun setupView() {

    }
}