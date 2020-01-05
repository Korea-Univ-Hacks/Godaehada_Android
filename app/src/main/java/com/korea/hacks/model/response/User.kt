package com.korea.hacks.model.response

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("portfolios") val portfolioList: MutableList<Portfolio>,
    @SerializedName("_id") val id: String,
    @SerializedName("nickname") val nickname: String
)