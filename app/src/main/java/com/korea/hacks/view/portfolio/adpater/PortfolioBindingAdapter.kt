package com.korea.hacks.view.portfolio.adpater

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.korea.hacks.util.ImageUtil
import org.jetbrains.annotations.NotNull

class PortfolioBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("set_image_url")
        fun setImageUrl(@NotNull view: ImageView, url: String) {
            ImageUtil.setImageUrl(view, url)
        }
    }
}