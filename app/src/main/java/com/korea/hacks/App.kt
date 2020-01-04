package com.korea.hacks

import android.app.Application
import com.korea.hacks.util.BasicUtil
import com.korea.hacks.view.portfolio.adpater.PortfolioBindingAdapter

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        BasicUtil.init(applicationContext)
        PortfolioBindingAdapter.init(applicationContext)
    }
}