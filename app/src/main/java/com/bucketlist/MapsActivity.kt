package com.bucketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.bucketlist.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    val mark = LatLng(39.1031, -84.5120)
    val mark2 = LatLng(39.1031, -83.5120)
    val mark3 = LatLng(39.1031, -82.5120)
    val mlocationArray = mutableListOf<LatLng>(mark, mark2, mark3)

    //val mark = LatLng(39.1031, -84.5120)


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Cincinnati and move the camera
        for (i in mlocationArray)
        mMap.addMarker(MarkerOptions().position(i).title("Marker in Cincinnati"))
        for (i in mlocationArray)
        mMap.animateCamera(CameraUpdateFactory.zoomTo(6.0f))
        for (i in mlocationArray)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(i))
    }
}