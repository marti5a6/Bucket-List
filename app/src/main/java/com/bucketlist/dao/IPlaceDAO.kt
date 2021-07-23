package com.bucketlist.dao

import com.bucketlist.dto.PlaceInfo
import retrofit2.Call
import retrofit2.http.GET

interface IPlaceDAO {

    @GET("https://maps.googleapis.com/maps/api/place/textsearch/json?query=hiking+in+Cincinnati&key=AIzaSyCUXXfPLIQDpEoO-CrZgILX349bAYPmF-o")
    fun getPlaces(): Call<ArrayList<PlaceInfo>>

}