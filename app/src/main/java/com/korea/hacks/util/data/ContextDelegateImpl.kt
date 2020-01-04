package com.korea.hacks.util.data

import android.content.Context
import com.korea.hacks.util.domain.ContextDelegate

class ContextDelegateImpl(private val context: Context): ContextDelegate {
    override fun getString(stringResId: Int)
            = context.resources.getString(stringResId)
}