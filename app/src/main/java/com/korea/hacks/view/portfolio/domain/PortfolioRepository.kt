package com.korea.hacks.view.portfolio.domain

import com.korea.hacks.view.portfolio.entity.PortfolioItem
import io.reactivex.Single

interface PortfolioRepository {

    fun requestPortfolioList(): Single<MutableList<PortfolioItem>>
}