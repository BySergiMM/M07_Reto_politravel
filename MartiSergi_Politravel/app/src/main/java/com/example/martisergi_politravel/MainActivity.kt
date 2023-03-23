package com.example.martisergi_politravel


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.RelativeLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    private val myImageView: ImageView by lazy { findViewById<ImageView>(R.id.myImageView) }
    private val imageList = listOf(R.drawable.desierto, R.drawable.playa, R.drawable.montana)

    private val handler = Handler()
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startImageTimer()

        val Layout = findViewById<RelativeLayout>(R.id.layout)

        Layout.setOnClickListener {
            val intent = Intent(this, PantallaPaquetes::class.java)
            startActivity(intent)
        }

        runnable = Runnable {
            val intent = Intent(this, PantallaPaquetes::class.java)
            startActivity(intent)
        }

        handler.postDelayed(runnable, 10000)


    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    private fun startImageTimer() {
        val handler = Handler()
        val imageTimer = Timer()

        imageTimer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                handler.post {
                    val randomIndex = (0 until imageList.size).random()
                    myImageView.setImageResource(imageList[randomIndex])
                }
            }
        }, 0, 3000)
    }
}