package com.korea.hacks.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.korea.hacks.R
import kotlinx.android.synthetic.main.category_item_view.view.*
import kotlin.collections.ArrayList

class CategoryRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var categoryList = ArrayList<String>()

    fun setItems(categoryList: ArrayList<String>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

    /**
     * diary_item_view 을 inflate 하여 뷰홀더 객체 생성
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CreateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_item_view, parent, false))

    /**
     * position 에 해당하는 데이터를 onCreateViewHolder 에서 만든 뷰홀더의 아이템뷰에 표시
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CreateViewHolder)?.onBind(categoryList, position)
    }

    override fun getItemCount() = categoryList.size

    inner class CreateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var pos = -1
        fun onBind(categoryList: ArrayList<String>, position: Int) {

            itemView.run {

                category_txt.text=categoryList[position]

                //TODO 각 아이템 뷰 클릭하면 상세화면 이동

                setOnClickListener {
                    //pos = position
                    category_txt.isPressed=true
                }


            }


        }
    }


}