package com.korea.hacks.view.portfolio.entity

class UserItem (
    val userImage: String,
    val name: String,
    val description: String,
    val rating: Float,
    val phone: String,
    val portfolioList: MutableList<PortfolioItem>
)