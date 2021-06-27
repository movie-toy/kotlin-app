//package com.toy.movietoy
//
//import android.content.Intent
//import android.os.Bundle
//import android.os.Handler
//import android.os.PersistableBundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_splash_screen.*
//
//class SplashScreenActivity : AppCompatActivity() {
//
//    val TAG: String = "로그"
//    lateinit var handler: Handler
//
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        Log.d(TAG,"SplashScreenActivity - onCreate() start")
//        super.onCreate(savedInstanceState, persistentState)
//        setContentView(R.layout.activity_splash_screen)
//
//        iv_note.alpha = 0f
//        iv_note.animate().setDuration(1500).alpha(1f).withEndAction {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
//            finish()
//        }
//
////        Log.d(TAG,"SplashScreenActivity - onCreate() middle")
////        handler.postDelayed({
////            val intent = Intent(this, MainActivity::class.java)
////            startActivity(intent)
////            finish()
////        }, 3000) // delay 3초
//
//        Log.d(TAG,"SplashScreenActivity - onCreate() end")
//    }
//}