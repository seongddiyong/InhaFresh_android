package com.example.inhafresh1

//import android.R
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.skt.Tmap.TMapView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val tmapview = TMapView(this)
        // tmapview.setSKTMapApiKey("l7xx1fa6658a1b6543a995821b7e849ff12f")

        val linearLayoutTmap = findViewById<View>(R.id.linearLayoutTmap) as LinearLayout
        val tMapView = TMapView(this)

        tMapView.setSKTMapApiKey("l7xx1fa6658a1b6543a995821b7e849ff12f")
        linearLayoutTmap.addView(tMapView)
    }


}