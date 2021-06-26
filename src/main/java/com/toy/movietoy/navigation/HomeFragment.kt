package com.toy.movietoy.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.toy.movietoy.ProfileAdapter
import com.toy.movietoy.Profiles
import com.toy.movietoy.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 리스트 정의 -> 추후 API 연동 데이터로 변경
        val profileDayList = arrayListOf(
            Profiles(R.drawable.image1, "영화1"),
            Profiles(R.drawable.image2, "영화2"),
            Profiles(R.drawable.image3, "영화3"),
            Profiles(R.drawable.image4, "영화4"),
            Profiles(R.drawable.image1, "영화1"),
            Profiles(R.drawable.image2, "영화2"),
            Profiles(R.drawable.image3, "영화3"),
            Profiles(R.drawable.image4, "영화4"),
        )

        rv_profile_day.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_profile_day.setHasFixedSize(true)
        rv_profile_day.adapter = ProfileAdapter(profileDayList)

        val profileWeekList = arrayListOf(
            Profiles(R.drawable.image1, "주간영화1"),
            Profiles(R.drawable.image2, "주간영화2"),
            Profiles(R.drawable.image3, "주간영화3"),
            Profiles(R.drawable.image4, "주간영화4"),
            Profiles(R.drawable.image1, "주간영화1"),
            Profiles(R.drawable.image2, "주간영화2"),
            Profiles(R.drawable.image3, "주간영화3"),
            Profiles(R.drawable.image4, "주간영화4"),
        )

        rv_profile_week.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_profile_week.setHasFixedSize(true)
        rv_profile_week.adapter = ProfileAdapter(profileWeekList)

        val profilePopList = arrayListOf(
            Profiles(R.drawable.image1, "인기영화1"),
            Profiles(R.drawable.image2, "인기영화2"),
            Profiles(R.drawable.image3, "인기영화3"),
            Profiles(R.drawable.image4, "인기영화4"),
            Profiles(R.drawable.image1, "인기영화1"),
            Profiles(R.drawable.image2, "인기영화2"),
            Profiles(R.drawable.image3, "인기영화3"),
            Profiles(R.drawable.image4, "인기영화4"),
        )

        rv_profile_pop.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_profile_pop.setHasFixedSize(true)
        rv_profile_pop.adapter = ProfileAdapter(profilePopList)
    }
}