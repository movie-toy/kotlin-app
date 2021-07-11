package com.toy.movietoy

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.toy.movietoy.model.Profiles

class ProfileAdapter(val profileList: ArrayList<Profiles>, val mContext: Context?) : Adapter<ProfileAdapter.CustomViewHolder>()
{
    val TAG: String = "로그"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_boxoffice, parent, false) // context(activity에서 담고있는 모든 정보)
        return CustomViewHolder(view) // CustomViewHolder의 itemView => view
    }

    /**
     * view에 대해 data Matching
     * */
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        val movieCd = profileList.get(position).movieCd
        val title = profileList.get(position).title
        holder.movieCd.text = movieCd.toString()
        holder.thumbnail.setImageResource(profileList.get(position).thumbnail)
        holder.title.text = title

        holder.thumbnail.setOnClickListener {
            Log.d(TAG, "ProfileAdapter - onBindViewHolder() called | movieCd: $movieCd")
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("movie_cd", movieCd)
            intent.putExtra("movie_title", title)
            mContext?.startActivity(intent)
        }
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
        val movieCd = itemView.findViewById<TextView>(R.id.tx_movie_cd) // 영화 코드
        val thumbnail = itemView.findViewById<ImageView>(R.id.iv_thumbnail) // 영화 이미지
        val title = itemView.findViewById<TextView>(R.id.tx_title) // 영화 제목
    }

}