package com.korea.hacks.util.domain

import androidx.annotation.StringRes

interface ContextDelegate {
    fun getString(@StringRes stringResId: Int): String
}