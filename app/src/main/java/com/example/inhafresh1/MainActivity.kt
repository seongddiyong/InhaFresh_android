package com.example.inhafresh1

import android.Manifest
import android.graphics.Color
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.inhafresh1.R
import com.skt.Tmap.*
import com.skt.Tmap.TMapGpsManager.onLocationChangedCallback

class MainActivity : AppCompatActivity(), onLocationChangedCallback {
    var API_Key = "l7xx1fa6658a1b6543a995821b7e849ff12f"

    // T Map View
    var tMapView: TMapView? = null

    // T Map GPS
    var tMapGPS: TMapGpsManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // T Map View
        tMapView = TMapView(this)

        // API Key
        tMapView!!.setSKTMapApiKey(API_Key)

        // Initial Setting
        tMapView!!.zoomLevel = 15
        tMapView!!.setIconVisibility(true)
        tMapView!!.mapType = TMapView.MAPTYPE_STANDARD
        tMapView!!.setLanguage(TMapView.LANGUAGE_KOREAN)

        // T Map View Using Linear Layout
        val linearLayoutTmap = findViewById<View>(R.id.linearLayoutTmap) as LinearLayout
        linearLayoutTmap.addView(tMapView)

        // Request For GPS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }

        // GPS using T Map
        tMapGPS = TMapGpsManager(this)

        // Initial Setting
        tMapGPS!!.minTime = 1000
        tMapGPS!!.minDistance = 10f
        tMapGPS!!.provider = TMapGpsManager.NETWORK_PROVIDER
        //tMapGPS.setProvider(tMapGPS.GPS_PROVIDER);
        tMapGPS!!.OpenGps()

        val tMapPointStart: TMapPoint = TMapPoint(37.570841, 126.985302)
        val tMapPointEnd: TMapPoint = TMapPoint(37.551135, 127.988205); // N서울타워(목적지)
        val tMapPolyLine: TMapPolyLine? = TMapData().findPathDataWithType(TMapData.TMapPathType.CAR_PATH, tMapPointStart, tMapPointEnd);

        if (tMapPolyLine != null) {
            tMapPolyLine.setLineColor(Color.BLUE)
        };
        if (tMapPolyLine != null) {
            tMapPolyLine.setLineWidth(2F)
        };
        tMapView!!.addTMapPolyLine("Line1", tMapPolyLine);
    }

    override fun onLocationChange(location: Location) {
        tMapView!!.setLocationPoint(location.longitude, location.latitude)
        tMapView!!.setCenterPoint(location.longitude, location.latitude)
    }
}