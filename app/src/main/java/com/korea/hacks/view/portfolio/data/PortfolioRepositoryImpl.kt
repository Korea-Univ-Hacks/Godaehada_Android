package com.korea.hacks.view.portfolio.data

import com.korea.hacks.view.portfolio.domain.PortfolioRepository
import com.korea.hacks.view.portfolio.entity.PortfolioItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class PortfolioRepositoryImpl: PortfolioRepository {

    override fun requestPortfolioList() = Single.fromCallable {
        val item1 = PortfolioItem(0, "BX디자인", "http://movie.phinf.naver.net/20171013_210/1507861351048TMJcR_JPEG/movie_image.jpg", true)
        val item2 = PortfolioItem(1, "UX디자인", "http://movie.phinf.naver.net/20171013_210/1507861351048TMJcR_JPEG/movie_image.jpg", true)
        val item3 = PortfolioItem(2, "추가해주세요", "", false)

        val itemList = mutableListOf<PortfolioItem>()
        itemList.add(item1)
        itemList.add(item2)
        itemList.add(item3)
        itemList
    }.subscribeOn(Schedulers.io())
}