package com.bucketlist.dao

import com.bucketlist.dto.PlaceInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlaceDAO {

   // @GET("https://maps.googleapis.com/maps/api/place/textsearch/json?query=hiking+in+Cincinnati")
    @GET("https://maps.googleapis.com/maps/api/place/nearbysearch/json?radius=200&type=point_of_interest")
    fun getPlaces(@Query("key") key: String,@Query("location") location: String): Call<ArrayList<PlaceInfo>>

}