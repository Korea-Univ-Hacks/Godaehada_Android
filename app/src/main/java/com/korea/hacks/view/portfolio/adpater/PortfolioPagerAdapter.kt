package com.korea.hacks.view.portfolio.adpater

import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.korea.hacks.view.portfolio.PortfolioFragment
import com.korea.hacks.view.portfolio.entity.PortfolioItem

class PortfolioPagerAdapter(
    @NonNull fm: FragmentManager,
    behavior: Int
): FragmentPagerAdapter(fm, behavior) {

    private val itemList = mutableListOf<PortfolioItem>()

    fun addAll(itemList: MutableList<PortfolioItem>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun getCount() = itemList.size

    override fun getItem(position: Int) =
        PortfolioFragment(itemList[position])
}