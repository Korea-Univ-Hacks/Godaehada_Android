package com.korea.hacks.util

import android.content.Context
import android.content.res.Resources

class BasicUtil {

    companion object {
        private lateinit var resources: Resources

        fun init(context: Context) {
            resources = context.resources
        }

        fun getDensity() = resources.displayMetrics.density

        fun getMargin(dp: Int): Int {
            val density: Float = getDensity()
            return (dp * density).toInt()
        }
    }
}