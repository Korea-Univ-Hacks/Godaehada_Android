package com.korea.hacks.view.portfolio.adpater

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.korea.hacks.util.ImageUtil
import com.korea.hacks.view.portfolio.entity.PortfolioItem
import org.jetbrains.annotations.NotNull

class PortfolioBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("set_portfolio_url")
        fun setImageUrl(@NotNull view: ImageView, item: PortfolioItem) {
            if (item.imageUrl.isNotEmpty()) {
                ImageUtil.setImageUrl(view, item.imageUrl)
                view.scaleType = ImageView.ScaleType.FIT_CENTER
            } else if (item.imageUri != null) {
                ImageUtil.setImageUri(view, item.imageUri)
                view.scaleType = ImageView.ScaleType.FIT_CENTER
            }
        }
    }
}