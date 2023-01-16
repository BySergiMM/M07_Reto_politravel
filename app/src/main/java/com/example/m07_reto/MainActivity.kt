package com.example.m07_reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private var countDownTimer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        progressBar.max = 10

        countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                progressBar.progress = (10000 - millisUntilFinished).toInt() / 1000
            }

            override fun onFinish() {
                //Cambia de actividad
            }
        }.start()

        findViewById<View>(R.id.jueves).setOnClickListener {
            countDownTimer?.cancel()
            //Cambia de actividad
        }
    }
}