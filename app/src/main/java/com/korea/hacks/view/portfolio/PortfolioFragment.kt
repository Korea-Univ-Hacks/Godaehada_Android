package com.korea.hacks.view.portfolio

import com.korea.hacks.R
import com.korea.hacks.base.BaseFragment
import com.korea.hacks.databinding.FragmentPortfolioBinding
import com.korea.hacks.view.portfolio.entity.PortfolioItem

class PortfolioFragment(private val item: PortfolioItem): BaseFragment<FragmentPortfolioBinding>() {

    override val layoutRes = R.layout.fragment_portfolio

    override fun onDataBinding() {
        binding.portfolioItem = item
        super.onDataBinding()
    }

    override fun setupView() {

    }
}