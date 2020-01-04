package com.korea.hacks.view.main

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityMainBinding
import com.korea.hacks.view.CategoryRecyclerViewAdapter
import com.korea.hacks.view.CreateRecyclerViewAdapter
import com.korea.hacks.view.Test
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity: BaseActivity<ActivityMainBinding>() {

    private var creatorList = ArrayList<Test>()
//    private var categoryList = ArrayList<String>()
    override val layoutRes = R.layout.activity_main

    fun test(){

        val tag = ArrayList<String>(listOf("로고디자인", "BX디자인"))
        val name = "김라희"

        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
    }

//    fun testForCategory(){
//
//        categoryList.add("홈")
//        categoryList.add("디자인")
//        categoryList.add("IT")
//        categoryList.add("콘텐츠")
//        categoryList.add("문서")
//        categoryList.add("번역")
//        categoryList.add("제품")
//
//    }

    //상단 카테고리 - 리사이클러뷰 어댑터
   // private val categoryRecyclerViewAdapter by lazy { CategoryRecyclerViewAdapter() }

    //그리드 - 리사이클러뷰 어댑터
    private val createRecyclerViewAdapter by lazy { CreateRecyclerViewAdapter() }

    override fun setupView() {

        binding.mainToolbar.menu_btn.setOnClickListener{
        //TODO 햄버거 버튼 누르면 열리기
        }

        test()
       // testForCategory()

//        //리사이클러 레이아웃 매니저
//        val linearLayoutManager = LinearLayoutManager(this)
//        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
//
//        //리사이클러뷰 초기화
//        binding.categoryRecyclerView.run {
//            adapter = categoryRecyclerViewAdapter
//            layoutManager = linearLayoutManager
//            setHasFixedSize(true)
//        }
//
//        categoryRecyclerViewAdapter.setItems(categoryList)

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
