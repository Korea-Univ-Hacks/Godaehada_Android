
package com.korea.hacks.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.korea.hacks.R
import kotlinx.android.synthetic.main.creator_item_view.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class Test(
    var name:String,
    var tag: MutableList<String>
)

class CreateRecyclerViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var creatorList = ArrayList<Test>()


    fun setItems(creatorList: ArrayList<Test>) {

        this.creatorList = creatorList
        notifyDataSetChanged()
    }


    /**
     * diary_item_view 을 inflate 하여 뷰홀더 객체 생성
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CreateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.creator_item_view, parent, false))

    /**
     * position 에 해당하는 데이터를 onCreateViewHolder 에서 만든 뷰홀더의 아이템뷰에 표시
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CreateViewHolder)?.onBind(creatorList, position)
    }

    override fun getItemCount() = creatorList.size


    /**
     * diary_item_view 를 보여주기 위한 뷰홀더
     */
    inner class CreateViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SimpleDateFormat")
        fun onBind(creatorList: ArrayList<Test>, position: Int) {
            var creator:Test = creatorList[position]

            itemView.run {

                val name = creatorList[position].name

                val tag = creatorList[position].tag

                var TAG=""
                for(t in tag){
                    TAG += "#" + t+" "
                }


                main_name_txt.text = name
                main_tag_txt.text = TAG

                //TODO 각 아이템 뷰 클릭하면 상세화면 이동
                /*
                setOnClickListener {
                    callEvent.onClickDiary(creator)
                }

                 */
            }


        }
    }


}