package com.example.inhafresh1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skt.Tmap.TMapTapi


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tmaptapi = TMapTapi(this)
        tmaptapi.setSKTMapAuthentication("l7xx1fa6658a1b6543a995821b7e849ff12")
    }

}