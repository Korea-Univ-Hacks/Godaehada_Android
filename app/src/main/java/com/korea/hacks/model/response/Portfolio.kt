package com.korea.hacks.model.response

import com.google.gson.annotations.SerializedName

data class Portfolio(
    @SerializedName("_id") val id: String,
    @SerializedName("category") val category: String,
    @SerializedName("tag") val ios: String,
    @SerializedName("portfolioThumbnail") val imageUrl: String
)