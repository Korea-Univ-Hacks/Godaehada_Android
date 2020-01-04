package com.korea.hacks.view.portfolio.entity

import android.net.Uri

class PortfolioItem(
    val id: Int,
    var tag: String,
    val imageUrl: String,
    var isSet: Boolean
) {
    var category: String = ""
    var imageUri: Uri? = null
}