package com.korea.hacks

import android.app.Application
import com.korea.hacks.util.BasicUtil

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        BasicUtil.init(applicationContext)
    }
}