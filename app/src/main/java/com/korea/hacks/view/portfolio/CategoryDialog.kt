package com.korea.hacks.view.portfolio

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.korea.hacks.R
import com.korea.hacks.view.portfolio.entity.CategoryItem


class CategoryDialog(@NonNull context: Context) : Dialog(context) {

    val categoryLiveData = MutableLiveData<CategoryItem>()
    var category = ""
    var pos = 0

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_category)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCanceledOnTouchOutside(true)

        val spinnerCategory = findViewById<Spinner>(R.id.spinner_category)
        val spinnerTag = findViewById<Spinner>(R.id.spinner_tag)
        val categoryAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, getCategory())
        spinnerCategory.adapter = categoryAdapter
        var tagAdapter: ArrayAdapter<String>
        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                category = getCategory()[position]
                pos = position
                tagAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, getTag(position))
                spinnerTag.adapter = tagAdapter
                spinnerTag.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        categoryLiveData.value = CategoryItem(category, getTag(pos)[position])
                        dismiss()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun getCategory() = arrayOf("디자인", "IT프로그래밍", "콘텐츠제작", "번역통역", "문서취업", "운세상담")

    private fun getTag(position: Int) = when(position) {
        0 -> getTagDesign()
        1 -> getTagProgramming()
        2 -> getTagContents()
        3 -> getTagTranslation()
        4 -> getTagDocument()
        5 -> getTagCounseling()
        else -> getTagDesign()
    }

    private fun getTagDesign() = arrayOf("로고디자인", "명함인쇄물", "웹모바일디자인", "PPT인포그래픽")
    private fun getTagProgramming() = arrayOf("워드프레스", "웹사이트개발", "쇼핑몰커머스", "모바일앱웹", "프로그램개발", "게임")
    private fun getTagContents() = arrayOf("영상촬영편집", "유튜브제작", "애니메이션", "3DVR")
    private fun getTagTranslation() = arrayOf("번역", "통역", "영상번역")
    private fun getTagDocument() = arrayOf("면접취업코칭", "자소서이력서", "카피라이팅", "논문")
    private fun getTagCounseling() = arrayOf("신점", "사주운세", "타로", "작명")
}