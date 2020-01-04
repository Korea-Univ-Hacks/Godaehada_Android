package com.korea.hacks.view.main

import androidx.databinding.DataBindingUtil
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity: BaseActivity<ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main

    override fun onDataBinding() {
        super.onDataBinding()
    }

    override fun setupView() {
        binding.mainToolbar.menu_btn.setOnClickListener{
        //TODO 햄버거 버튼 누르면 열리기

        }


    }
}
