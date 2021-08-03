package com.example.kotlinprojectstructure

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.util.*

class SplashActivity : AppCompatActivity() {
    companion object {
        const val SPLASH_DELAY = 2000L
    }
    private lateinit var timer: Timer
    private lateinit var timerTask: TimerTask
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        context=this
        init()
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        scheduleSplash()
    }
    private fun init() {
        timer = Timer()
        timerTask = object : TimerTask() {
            override fun run() {
                Toast.makeText(context, "Splash", Toast.LENGTH_SHORT).show()
            }
        }
    }//

    private fun scheduleSplash() {
        timer.schedule(timerTask, SPLASH_DELAY)
    }
}