package com.korea.hacks.view.main.adapter

import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.korea.hacks.R
import com.korea.hacks.util.domain.ContextDelegate
import com.korea.hacks.view.main.MainFragment

class MainPagerAdapter(
    @NonNull fm: FragmentManager,
    behavior: Int,
    private val contextDelegate: ContextDelegate
): FragmentPagerAdapter(fm, behavior) {

    override fun getCount() = 5

    override fun getItem(position: Int) = MainFragment()

    override fun getPageTitle(position: Int) = when (position) {
        0 -> contextDelegate.getString(R.string.main_tab_home)
        1 -> contextDelegate.getString(R.string.main_tab_design)
        2 -> contextDelegate.getString(R.string.main_tab_it)
        3 -> contextDelegate.getString(R.string.main_tab_contents)
        4 -> contextDelegate.getString(R.string.main_tab_document)
        else -> super.getPageTitle(position)
    }
}