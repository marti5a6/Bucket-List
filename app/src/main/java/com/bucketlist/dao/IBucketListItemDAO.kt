package com.bucketlist.dao

import com.bucketlist.dto.BucketListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IBucketListItemDAO {
    // hard code items?
    @GET("")
    suspend fun getAllItems(): ArrayList<BucketListItem>

    @GET("")
    fun getItems(@Query("Combined_Name") bucketListItemName:String
    ): Call<ArrayList<BucketListItem>>
}