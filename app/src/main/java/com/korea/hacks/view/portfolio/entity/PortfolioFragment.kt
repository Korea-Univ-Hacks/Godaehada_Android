package com.korea.hacks.view.portfolio.entity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.korea.hacks.databinding.FragmentPortfolioBinding

class PortfolioFragment(private val item: PortfolioItem): Fragment() {

    private lateinit var binding: FragmentPortfolioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPortfolioBinding.inflate(
            LayoutInflater.from(container?.context), container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onDataBinding()
    }

    private fun onDataBinding() {
        binding.portfolioItem = item
    }
}