package com.toy.movietoy.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.toy.movietoy.DetailActivity
import com.toy.movietoy.ProfileAdapter
import com.toy.movietoy.model.Profiles
import com.toy.movietoy.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    val TAG: String = "로그"


    /**
     * 뷰 화면 생성 시
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG,"HomeFragment - onCreateView() called")
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_home, container, false)
        return view
    }

    /**
     * 액티비티 생성 시 (순서: onCreateView -> onActivityCreated)
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG,"HomeFragment - onActivityCreated() called")

        // 리스트 정의 -> 추후 API 연동 데이터로 변경
        // 일간 API 조회 시
        val profileDayList = arrayListOf(
            Profiles(11, R.drawable.image1, "영화1"),
            Profiles(12, R.drawable.image2, "영화2"),
            Profiles(13, R.drawable.image3, "영화3"),
            Profiles(14, R.drawable.image4, "영화4"),
            Profiles(15, R.drawable.image1, "영화1"),
            Profiles(16, R.drawable.image2, "영화2"),
            Profiles(17, R.drawable.image3, "영화3"),
            Profiles(18, R.drawable.image4, "영화4"),
        )
        rv_profile_day.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_profile_day.setHasFixedSize(true)
        rv_profile_day.adapter = ProfileAdapter(profileDayList, context)

        // 주간 API 조회 시
        val profileWeekList = arrayListOf(
            Profiles(21, R.drawable.image1, "주간영화1"),
            Profiles(22, R.drawable.image2, "주간영화2"),
            Profiles(23, R.drawable.image3, "주간영화3"),
            Profiles(24, R.drawable.image4, "주간영화4"),
            Profiles(25, R.drawable.image1, "주간영화1"),
            Profiles(26, R.drawable.image2, "주간영화2"),
            Profiles(27, R.drawable.image3, "주간영화3"),
            Profiles(28, R.drawable.image4, "주간영화4"),
        )
        rv_profile_week.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_profile_week.setHasFixedSize(true)
        rv_profile_week.adapter = ProfileAdapter(profileWeekList, context)

        // 인기 API 조회 시
        val profilePopList = arrayListOf(
            Profiles(31, R.drawable.image1, "인기영화1"),
            Profiles(32, R.drawable.image2, "인기영화2"),
            Profiles(33, R.drawable.image3, "인기영화3"),
            Profiles(34, R.drawable.image4, "인기영화4"),
            Profiles(35, R.drawable.image1, "인기영화1"),
            Profiles(36, R.drawable.image2, "인기영화2"),
            Profiles(37, R.drawable.image3, "인기영화3"),
            Profiles(38, R.drawable.image4, "인기영화4"),
        )
        rv_profile_pop.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_profile_pop.setHasFixedSize(true)
        rv_profile_pop.adapter = ProfileAdapter(profilePopList, context)

        // 특정 화면 클릭 시
        tv_daily_rank.setOnClickListener(View.OnClickListener {
            onMovieClicked()
        })

        rv_profile_day.setOnClickListener(View.OnClickListener { 
            Log.d(TAG, "HomeFragment - onActivityCreated() called")
        })
    }

    /**
     * 영화 클릭 시
     */
    fun onMovieClicked(){
        Log.d(TAG,"HomeFragment - onMovieClicked() called")
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("movie_cd", 12345)
        intent.putExtra("movie_title", "영화는 영화다")
        startActivity(intent)
    }
}