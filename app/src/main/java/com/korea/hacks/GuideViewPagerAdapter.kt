package com.korea.hacks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.page_view.view.*


class GuideViewPagerAdapter : PagerAdapter() {

    /**
     * 페이지뷰 생성해 position 별로 이미지 로드
     * 뷰페이저에 추가
     *
     * @param container 페이지뷰를 그릴 상위 뷰:뷰페이저
     * @param position 각 페이지뷰의 position
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        //페이지뷰 레이아웃 리소스를 LayoutInflater 를 통해 뷰로 변환->  뷰페이저의 페이지뷰 화면 생성
        val pageView = LayoutInflater.from(container.context).inflate(R.layout.page_view, container, false)

        pageView.guide_img.run {
            if (position == 0) {
                this.setImageResource(R.drawable.card_2)
            } else {
                this.setImageResource(R.drawable.ad1)
            }
        }

        container.addView(pageView)

        return pageView
    }

    /**
     * 뷰 페이저 키 객체와 페이지뷰가 연관되는지 여부 확인
     * instantiateItem 리턴 객체와 비교한다.
     *
     * @param view instantiateItem 에서 넘겨받은 페이지 뷰
     * @param _object 뷰 페이저 키 객체
     *
     * @return 비교 값 (같으면 true 다르면 false)
     */
    override fun isViewFromObject(view: View, _object: Any): Boolean {

        return view == _object as View
    }


    /**
     * 뷰페이저에서 페이지뷰 제거
     *
     * @param _object 페이지뷰
     */
    override fun destroyItem(container: ViewGroup, position: Int, _object: Any) {

        container.removeView(_object as View?)
    }

    /**
     * 전체 페이지 수 2 로 고정
     */
    override fun getCount(): Int {

        return 2
    }
}