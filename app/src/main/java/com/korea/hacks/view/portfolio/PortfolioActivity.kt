package com.korea.hacks.view.portfolio

import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityPortfolioBinding
import com.korea.hacks.util.BasicUtil
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
        val margin = BasicUtil.getMargin(50)
        with(binding) {
            viewPager.clipToPadding = false
            viewPager.setPadding(margin, 0, margin, 0)
            viewPager.pageMargin = margin / 2
            viewPager.adapter = adapter
            viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
                override fun onPageSelected(position: Int) {
                    // TODO
                }
                override fun onPageScrollStateChanged(state: Int) {}
            })
            tabLayout.setupWithViewPager(viewPager)
        }
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
