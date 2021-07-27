package com.bucketlist.dao

import com.bucketlist.dto.PlaceInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlaceDAO {

    @GET("https://maps.googleapis.com/maps/api/place/textsearch/json?query=hiking+in+Cincinnati")
    fun getPlaces(@Query("key") key: String): Call<ArrayList<PlaceInfo>>

}