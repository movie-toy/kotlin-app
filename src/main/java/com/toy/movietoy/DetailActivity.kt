package com.toy.movietoy

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    val TAG: String = "로그"

    /**
     * 액티비티 화면 생성 시
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // xml 뷰 파일 연결
        setContentView(R.layout.activity_detail)

        // 데이터 세팅
        setDetailData()        

        // 뒤로가기 버튼 뷰에 클릭 리스너 설정
        iv_back.setOnClickListener(View.OnClickListener {
            onBackButtonClicked()
        })
    }

    /**
     * 뒤로가기 버튼 클릭 시
     */
    fun onBackButtonClicked(){
        Log.d(TAG, "DetailActivity - onBackButtonClicked() called")
        finish()
    }

    /**
     * 상세 데이터 저장
     */
    fun setDetailData(){
        // 화면 값 설정
        Log.d(TAG,"DetailActivity - setDetailData() called")
        val movieCd = intent.getIntExtra("movie_cd", 0)
        val movieTitle = intent.getStringExtra("movie_title")
        Log.d(TAG,"DetailActivity - onCreate() | movieCd: $movieCd | movieTitle: $movieTitle")
        tv_movie_cd.text = movieCd.toString()
        tv_movie_title.text = movieTitle
    }
}