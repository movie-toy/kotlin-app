package com.toy.movietoy

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    val TAG: String = "로그"

    // 뷰 생성 시
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // xml 뷰 파일 연결
        setContentView(R.layout.activity_detail)

        // 뒤로가기 버튼 뷰에 클릭 리스터를 설정
        iv_back.setOnClickListener(View.OnClickListener {
            onBackButtonClicked()
        })
    }

    fun onBackButtonClicked(){
        Log.d(TAG, "DetailActivity - onBackButtonClicked() called")
        finish()
    }
}