package com.korea.hacks.view.chat

import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityChatBinding

class ChatActivity: BaseActivity<ActivityChatBinding>() {
    override val layoutRes = R.layout.activity_chat

    override fun onDataBinding() {

        super.onDataBinding()
    }

    override fun setupView() {
        initToolbar()
    }

    private fun initToolbar() {
    }
}
