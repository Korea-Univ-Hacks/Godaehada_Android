package com.korea.hacks.view.portfolio

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.korea.hacks.base.BaseViewModel
import com.korea.hacks.view.portfolio.domain.PortfolioRepository
import com.korea.hacks.view.portfolio.entity.PortfolioItem
import io.reactivex.android.schedulers.AndroidSchedulers

class PortfolioViewModel(private val repo: PortfolioRepository): BaseViewModel() {

    private val TAG = PortfolioViewModel::class.java.name
    val portfolioList = MutableLiveData<MutableList<PortfolioItem>>()

    fun requestPortfolioList() {
        repo.requestPortfolioList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handlePortfolioList, this::handleError)
            .register()
    }

    private fun handlePortfolioList(portfolioList: MutableList<PortfolioItem>) {
        this.portfolioList.value = portfolioList
    }

    private fun handleError(throwable: Throwable) {
        throwable.message?.let {
            Log.e(TAG, it)
        }
    }
}