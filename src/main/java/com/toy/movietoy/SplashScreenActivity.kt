package com.toy.movietoy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    val TAG: String = "로그"
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        Log.d(TAG,"SplashScreenActivity - onCreate() start")
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.splash_screen_activity)

        Log.d(TAG,"SplashScreenActivity - onCreate() middle")
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // delay 3초

        Log.d(TAG,"SplashScreenActivity - onCreate() end")
    }
}