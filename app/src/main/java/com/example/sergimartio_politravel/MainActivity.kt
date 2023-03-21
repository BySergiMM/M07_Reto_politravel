package com.example.sergimartio_politravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val myImageView: ImageView by lazy { findViewById<ImageView>(R.id.myImageView) }
    private val imageList = listOf(R.drawable.desierto, R.drawable.playa, R.drawable.montana)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startImageTimer()

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