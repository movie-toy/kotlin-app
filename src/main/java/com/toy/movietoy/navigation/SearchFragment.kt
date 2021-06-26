package com.toy.movietoy.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.toy.movietoy.R

class SearchFragment : Fragment() {

    // https://youtu.be/oE8nZRJ9vxA 참고
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_search, container, false)
        return view



    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        val user = arrayOf("홍심", "감자","누구","시계","물","워터","구름","이쁘다","최준","나이스","SG워너비")

        val userAdapter : ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, user)
        )
    }*/


}