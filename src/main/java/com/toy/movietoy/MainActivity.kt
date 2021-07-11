package com.toy.movietoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.toy.movietoy.navigation.HomeFragment
import com.toy.movietoy.navigation.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 참고 : https://github.com/you6878/howlstagram
 * https://dudmy.net/android/2017/04/09/improved-loading-screen/
 * https://www.youtube.com/watch?v=bRusWAEn5GA
 * https://www.youtube.com/watch?v=WlJszSmK_es&t=3860s
 * https://www.youtube.com/watch?v=7XBX4XZTnd8&list=PLgOlaPUIbynrDSTJxS8AaE-2zYvPCjWtF&index=13
 * https://www.youtube.com/watch?v=8O_fTpMybiE&list=PLgOlaPUIbynrDSTJxS8AaE-2zYvPCjWtF&index=25
 * https://youtu.be/oE8nZRJ9vxA
 * https://material.io/
 * */
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    val TAG: String = "로그"
    /**
     * 완료
     * 영화 정보 클릭 시, 상세 페이지 이동 (파라미터 전달)
     * 검색 기본 틀 구현
     *
     * 할일
     * 상세 페이지 > 상세 구현
     * 검색 > 영화 컨텐츠 리스트 구현
     * splash Screen > 구현
     * */

    private var homeFragment = HomeFragment()
    private var searchFragment = SearchFragment()
//    private var userFragment = UserFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"MainActivity - onCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(this)

        Log.d(TAG,"MainActivity - onCreate() called 2")

        // default home fragment 이동
        supportFragmentManager.beginTransaction().replace(R.id.main_content,homeFragment).commit();

        // default 주간 모드 변경
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Log.d(TAG,"MainActivity - onCreate() called 3")
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.action_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_content,homeFragment).commit()
                return true
            }
            R.id.action_search -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_content,searchFragment).commit()
                return true
            }
            /*R.id.action_account -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_content,userFragment).commit()
                return true
            }*/
        }
        return false
    }

}