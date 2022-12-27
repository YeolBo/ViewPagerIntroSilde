package com.lee.myviewpagerintrosilde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    // 데이터 배열 준비
    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")

        previous_btn.setOnClickListener{
            Log.d(TAG, "MainActivity - 이전 버튼 클릭")
            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem - 1
        }
        next_btn.setOnClickListener{
            Log.d(TAG, "MainActivity - 다음 버튼 클릭")
            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem + 1
        }

        // 상태 표시줄 숨기기
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

        // 데이터 배열을 준비
        pageItemList.add(PageItem(R.color.colorOrange, R.drawable.ic_pager_item_1, "안녕하세요\n" +
                "이환열 입니다."))
        pageItemList.add(PageItem(R.color.colorBlue, R.drawable.ic_pager_item_2, "ViewPager2 Test!"))
        pageItemList.add(PageItem(R.color.colorWhite, R.drawable.ic_pager_item_3, "!!success!!"))

        // 어답터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        my_intro_view_pager.apply {
            adapter = myIntroPagerRecyclerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            dots_indicator.attachTo(viewPager2 = this)
        }

    }

}