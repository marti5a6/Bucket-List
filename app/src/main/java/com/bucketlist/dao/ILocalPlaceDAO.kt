package com.bucketlist.dao

import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import com.bucketlist.dto.PlaceInfo
import androidx.room.*
import retrofit2.Call

interface ILocalPlaceDAO {
//    @Query("SELECT * FROM places")
//    fun suspend getAllPlaces()  : ArrayList<PlaceInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: Call<ArrayList<PlaceInfo>>)

    @Delete
    fun delete(plant: PlaceInfo)

    @Insert
    fun save(plant: PlaceInfo)
}