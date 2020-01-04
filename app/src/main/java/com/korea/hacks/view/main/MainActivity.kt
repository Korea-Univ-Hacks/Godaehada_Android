package com.korea.hacks.view.main

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityMainBinding
import com.korea.hacks.view.CreateRecyclerViewAdapter
import com.korea.hacks.view.Test
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*


class MainActivity: BaseActivity<ActivityMainBinding>() {

    private var creatorList = ArrayList<Test>()
    override val layoutRes = R.layout.activity_main

    fun test(){

//        val tag = mutableListOf<String>("로고디자인", "BX디자인", "앱디자인")
//        val name = "김라희"
//        val tag2 = mutableListOf<String>("ㅁ", "ㄴㄴ", "ㄷㄷ")
//        val name2 = "강인혁"
//        val tag3 = mutableListOf<String>("ㅁㅇㄴㅇㄹ", "ㄴㄴ", "ㄷㄷ")
//        val name3 = "김윤진"

        //val c = mutableListOf<Test>()

        val tag = ArrayList<String>(listOf("로고디자인", "BX디자인"))
        val name = "김라희"


        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))

//        c.add(Test(name, tag))
//        c.add(Test(name2, tag2))
//        c.add(Test(name, tag))
//        c.add(Test(name2, tag2))
//        c.add(Test(name3, tag3))
//        c.add(Test(name3, tag3))


    }

    //리사이클러뷰 어댑터
    private val createRecyclerViewAdapter by lazy { CreateRecyclerViewAdapter() }

    override fun onDataBinding() {
        super.onDataBinding()
    }

    override fun setupView() {


        binding.mainToolbar.menu_btn.setOnClickListener{
        //TODO 햄버거 버튼 누르면 열리기
        }

        test()

        //그리드 레이아웃 매니저
        val gridLayoutManager = GridLayoutManager(this, 2)

        //리사이클러뷰 초기화
        binding.creatorRecyclerView.run {
            adapter = createRecyclerViewAdapter
            layoutManager = gridLayoutManager
            setHasFixedSize(true)
        }



        createRecyclerViewAdapter.setItems(creatorList)

    }
}
