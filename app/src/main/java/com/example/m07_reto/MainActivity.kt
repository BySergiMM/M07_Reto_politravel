package com.example.m07_reto

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

private lateinit var progressBar: ProgressBar
private val delay: Long = 10000 // 10 segundos

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressbar)
        progressBar.progress = 0

        val task = object : CountDownTimer(delay, 100) {
            override fun onTick(millisUntilFinished: Long) {
                progressBar.progress = 100 - (millisUntilFinished / 100).toInt()
            }
            override fun onFinish() {
                finish()
                val intent = Intent(this@MainActivity, lista::class.java)
                startActivity(intent)
            }
        }.start()

        val pantalla = findViewById<View>(R.id.jueves)

        pantalla.setOnClickListener {
            finish()
            val intent = Intent(this, lista::class.java)
            startActivity(intent)
        }
    }
}