package com.korea.hacks.view.main

import android.content.Context
import android.content.Intent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.korea.hacks.CallEvent
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityMainBinding
import com.korea.hacks.view.CreateRecyclerViewAdapter
import com.korea.hacks.view.Test
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity : BaseActivity<ActivityMainBinding>(){
    //class MainActivity : BaseActivity<ActivityMainBinding>(), CallEvent{

    override val layoutRes = R.layout.activity_main

    var selectedCategory = "홈"  //카테고리
    private var searchWord = ""   //검색어

    //그리드 - 리사이클러뷰 어댑터
    private val createRecyclerViewAdapter by lazy { CreateRecyclerViewAdapter() }
  //  private val createRecyclerViewAdapter by lazy { CreateRecyclerViewAdapter(this) }

    //TODO 검색 결과 리스트 셋팅
    private var creatorList = ArrayList<Test>()

    fun test() {

        val tag = ArrayList<String>(listOf("로고디자인", "BX디자인"))
        val name = "김라희"

        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
        creatorList.add(Test(name, tag))
    }

    override fun onDataBinding() {
        super.onDataBinding()
    }

    override fun setupView() {

        txt1.isSelected = true

        binding.mainToolbar.menu_btn.setOnClickListener {
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

        /**
         * 검색버튼 실행시키는 이벤트
         */
        //(1) 검색 버튼 클릭 -> 검색!!
        binding.searchImg.setOnClickListener {
            onClickSearchBtn()
        }
        //(2) 디바이스 키보드 엔터시 -> 검색!!
        binding.searchEdit.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                onClickSearchBtn()
                handled = true
            }
            handled
        }

        //(3) 카테고리 버튼 클릭 -> 검색!!
        binding.txt1.setOnClickListener {
            buttonInit()
            txt1.isSelected = true
            selectedCategory = "홈"
            onClickSearchBtn()
        }
        binding.txt2.setOnClickListener {
            buttonInit()
            txt2.isSelected = true
            selectedCategory = "디자인"
            onClickSearchBtn()
        }
        binding.txt3.setOnClickListener {
            buttonInit()
            txt3.isSelected = true
            selectedCategory = "IT"
            onClickSearchBtn()
        }
        binding.txt4.setOnClickListener {
            buttonInit()
            txt4.isSelected = true
            selectedCategory = "콘텐츠"
            onClickSearchBtn()
        }
        binding.txt5.setOnClickListener {
            buttonInit()
            txt5.isSelected = true
            selectedCategory = "번역"
            onClickSearchBtn()
        }
    }

    /**
     * 검색 버튼 또는 카테고리 선택시 실행!!
     */
    private fun onClickSearchBtn() {
        //키보드 내리기
        onCloseKeyboard()

        //스크롤 최상단으로 올리기
        binding.creatorRecyclerView.layoutManager!!.scrollToPosition(0)

        //검색창에 검색어가 있으면,
        if (binding.searchEdit.text.toString() != "") {
            searchWord = binding.searchEdit.text.toString()
            Toast.makeText(this, searchWord + " " + selectedCategory, Toast.LENGTH_SHORT).show()
            //TODO 검색명령

//            //뷰모델에 이미지 검색 명령
//            searchWord = binding.searchEdit.text.toString()
//            viewModel.getImageSearch(searchWord, sort, 1, size)

        }
//        else {    //검색창에 검색어가 없으면 검색어를 입력하라는 토스트 메세지 띄우기
//            Toast.makeText(this, "검색어를 입력해주세요", Toast.LENGTH_SHORT).show()
//        }
    }

    /**
     * 특정 크리에이터 클릭 시, 포트폴리오보기 화면으로 넘어감
     * TODO **************************************
     */

    /**
     * 데일리 다이어리 리스트에서 특정 다이어리를 클릭하면 상세보기 화면으로 이동
     */


    private fun buttonInit() {
        binding.txt1.isSelected = false
        binding.txt2.isSelected = false
        binding.txt3.isSelected = false
        binding.txt4.isSelected = false
        binding.txt5.isSelected = false
    }

    private fun onCloseKeyboard() {
        this.currentFocus?.let { view ->
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

//    override fun onClickImage(test: Test) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        //        val intent = Intent(this, DetailActivity::class.java)
////        intent.putExtra("diary", diary)
////        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
////
////        startActivity(intent)
//    }


}
