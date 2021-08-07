package com.bucketlist.service

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.bucketlist.dao.ILocalPlaceDAO
import com.bucketlist.dao.IPlaceDAO
import com.bucketlist.dao.PlacesDatabase
import com.bucketlist.dto.PlaceInfo
import com.bucketlist.ui.main.RetrofitClientInstance
import android.content.ContentValues.TAG
import kotlinx.coroutines.*
import retrofit2.Call

class PlaceService(application: Application) {
    private val application = application
    private var locationString = "36.950030,14.537220"

    internal suspend fun fetchPlaces(name: String) {
        withContext(Dispatchers.IO) {
            if(name!=null){locationString=name}
            val service = RetrofitClientInstance.retrofitInstance?.create(IPlaceDAO::class.java)
            val apikey: String = System.getenv("gapi_k") ?: "default_value"
            val places = async {service?.getPlaces(apikey,locationString)}

            coroutineScope {
                launch{
                    updateLocalPlaces(places.await())
                }
            }
        }
    }

    /**
     * Store these places locally, so that we can use the data without network latency
     */
    private fun updateLocalPlaces(places: Call<ArrayList<PlaceInfo>>?) {
     //  var sizeOfPlaces = places?.size
        try {
            var localPlaceDAO = getLocalPlaceDAO()
            localPlaceDAO.insertAll(places!!)
        }catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
        }

    }

    internal fun getLocalPlaceDAO(): ILocalPlaceDAO {
        val db = Room.databaseBuilder(application, PlacesDatabase::class.java, "myPlaces").build()
        return db.localPlaceDAO()
    }

    internal fun save(place:PlaceInfo) {
        getLocalPlaceDAO().save(place)
    }
}