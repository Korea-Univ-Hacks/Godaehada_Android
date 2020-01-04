package com.korea.hacks.view.portfolio

import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityPortfolioBinding
import com.korea.hacks.view.portfolio.adpater.PortfolioPagerAdapter
import com.korea.hacks.view.portfolio.data.PortfolioRepositoryImpl

class PortfolioActivity: BaseActivity<ActivityPortfolioBinding>() {
    override val layoutRes = R.layout.activity_portfolio
    private val portfolioViewModel = PortfolioViewModel(PortfolioRepositoryImpl())

    override fun onDataBinding() {

        super.onDataBinding()
    }

    override fun setupView() {
        initPortfolioPagerAdapter()
        observePortfolioViewModel()
        initView()
    }

    private fun initPortfolioPagerAdapter() {

        val adapter = PortfolioPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        binding.viewPager.adapter = adapter
    }

    private fun observePortfolioViewModel() {
        val owner = this
        with(portfolioViewModel) {
            portfolioList.observe(owner, Observer {
                (binding.viewPager.adapter as PortfolioPagerAdapter).addAll(it)
            })
        }
    }

    private fun initView() {
        portfolioViewModel.requestPortfolioList()
    }
}
