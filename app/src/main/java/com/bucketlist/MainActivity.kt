package com.bucketlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bucketlist.ui.main.BucketListMapFragment
import com.bucketlist.ui.main.MainFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val spinner: Spinner = findViewById(R.id.interests_spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.interests_array,
            android.R.layout.simple_spinner_item,
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val searchButton = findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {

        }
       val btnMap =  findViewById<Button>(R.id.btnMap)
       btnMap.setOnClickListener{
           val intent = Intent(this, MapsActivity::class.java)
           startActivity(intent)

       }
     fun onOpenMap() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, BucketListMapFragment())
            .commitNow()
     }


    }

}