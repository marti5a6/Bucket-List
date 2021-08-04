package com.bucketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bucketlist.dto.PlaceInfo
import com.bucketlist.ui.main.PlaceFragment

class PlacesActivity : AppCompatActivity() {
    private val placesList = ArrayList<PlaceInfo>()
    private lateinit var placesAdapter: PlaceFragment.PlaceInfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)
        preparePlacesData()

        // wire up recycler view.

val placeFrag : PlaceFragment = PlaceFragment()
     //   placesAdapter = placeFrag.PlaceInfoAdapter(placesList, R.layout.rowlayout)
        preparePlacesData()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = placeFrag.PlaceInfoAdapter(placesList, R.layout.rowlayout)

    }
    /*
    build temporary array of data for recyclerview until pulling from google and local db
    is finished
    * */
    private fun preparePlacesData() {
       // var types: ArrayList<String> = ArrayList<String>()
      //  types.add("point of interest")

        var place = PlaceInfo("Mad Max: Fury Road", "Action & Adventure")
        placesList.add(place)
        place = PlaceInfo("Inside Out", "Animation, Kids & Family")
        placesList.add(place)
        place = PlaceInfo("Star Wars: Episode VII - The Force Awakens", "Action")
        placesList.add(place)

    }
}