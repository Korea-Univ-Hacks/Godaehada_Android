package com.korea.hacks.view.portfolio.data

import com.korea.hacks.view.portfolio.domain.PortfolioRepository
import com.korea.hacks.view.portfolio.entity.PortfolioItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class PortfolioRepositoryImpl: PortfolioRepository {

    override fun requestPortfolioList() = Single.fromCallable {
        val item = PortfolioItem("영화", "범죄도시", "마동석짱", "http://movie.phinf.naver.net/20170915_299/1505458505658vbKcN_JPEG/movie_image.jpg")
        val itemList = mutableListOf<PortfolioItem>()
        for (i in 0..2) {
            itemList.add(item)
        }
        itemList
    }.subscribeOn(Schedulers.io())
}