package com.korea.hacks.view.main

import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityMainBinding
import com.korea.hacks.util.data.ContextDelegateImpl
import com.korea.hacks.view.main.adapter.MainPagerAdapter

class MainActivity: BaseActivity<ActivityMainBinding>() {
    override val layoutRes = R.layout.activity_main

    override fun onDataBinding() {
        // TODO
        super.onDataBinding()
    }

    override fun setupView() {
        initPagerAdapter()
    }

    private fun initPagerAdapter() {

        val mainPagerAdapter = MainPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            ContextDelegateImpl(applicationContext)
        )

        with(binding) {
            viewPager.adapter = mainPagerAdapter
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
}
