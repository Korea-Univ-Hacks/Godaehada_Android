package com.korea.hacks.view.portfolio

import com.korea.hacks.R
import com.korea.hacks.base.BaseFragment
import com.korea.hacks.databinding.FragmentPortfolioBinding
import com.korea.hacks.view.portfolio.entity.PortfolioItem

class PortfolioFragment(
    private val viewModel: PortfolioViewModel,
    private val item: PortfolioItem
): BaseFragment<FragmentPortfolioBinding>() {

    companion object {
        const val EXTRA_IMAGE_URL = "EXTRA_IMAGE_URL"
    }

    override val layoutRes = R.layout.fragment_portfolio

    override fun onDataBinding() {
        binding.vm = viewModel
        binding.item = item
        super.onDataBinding()
    }
}