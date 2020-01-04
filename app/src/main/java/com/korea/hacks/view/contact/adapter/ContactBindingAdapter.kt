package com.korea.hacks.view.contact.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.korea.hacks.util.ImageUtil
import com.korea.hacks.view.portfolio.entity.PortfolioItem
import org.jetbrains.annotations.NotNull

class ContactBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("set_contact_url")
        fun setImageUrl(@NotNull view: ImageView, url: String) {
            ImageUtil.setImageUrl(view, url)
        }
    }
}