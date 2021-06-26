package com.toy.movietoy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ProfileAdapter(val profileList: ArrayList<Profiles>) : Adapter<ProfileAdapter.CustomViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_boxoffice, parent, false) // context(activity에서 담고있는 모든 정보)
        return CustomViewHolder(view) // CustomViewHolder의 itemView => view
    }

    /**
     * view에 대해 data Matching
     * */
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.profile.setImageResource(profileList.get(position).profile)
        holder.title.text = profileList.get(position).title
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    // 
    // : java의 extends와 동일
    /**
     * 내부 클래스 (Class 안에 Class)
     * ":"의 의미 java에서 extends(상속)과 동일
     * */
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val profile = itemView.findViewById<ImageView>(R.id.iv_profile) // 영화 이미지
        val title = itemView.findViewById<TextView>(R.id.tx_title) // 영화 제목
    }

}