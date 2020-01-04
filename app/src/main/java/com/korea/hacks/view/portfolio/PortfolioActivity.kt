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
import com.korea.hacks.view.portfolio.entity.ViewType


class PortfolioActivity: BaseActivity<ActivityPortfolioBinding>() {

    override val layoutRes = R.layout.activity_portfolio
    private val portfolioViewModel = PortfolioViewModel(PortfolioRepositoryImpl())

    /** 1. 메인화면에서 구매자가 판매자의 포트폴리오에 접근하는 경우
     *  - 수정 불가, 카메라 진입 불가, 문의하기 진입 가능
     *  2. 마이페이지에서 판매자가 마이페이지로 접근하는 경우
     *  - 수정 가능, 카메라 진입 가능, 문의하기 진입 불가
     */
    companion object {
        const val EXTRA_IS_BUYER = "EXTRA_IS_BUYER"
    }
    private var isBuyer = false

    override fun onDataBinding() {
        binding.vm = portfolioViewModel
        super.onDataBinding()
    }

    override fun setupView() {
        getData()
        initPortfolioPagerAdapter()
        observePortfolioViewModel()
        initView()
    }

    private fun getData() {
        isBuyer = intent.getBooleanExtra(EXTRA_IS_BUYER, true)
    }

    private fun initPortfolioPagerAdapter() {

        val adapter = PortfolioPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            isBuyer
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
            moveViewEvent.observe(owner, Observer { viewType ->
                when (viewType) {
                    ViewType.BACK -> finish()
                    ViewType.CHAT -> {
                        // TODO
                    }
                    else -> {}
                }
            })
            portfolioList.observe(owner, Observer {
                (binding.viewPager.adapter as PortfolioPagerAdapter).addAll(it)
            })
        }
    }

    private fun initView() {
        portfolioViewModel.requestPortfolioList()
    }
}
