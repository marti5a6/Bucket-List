package com.bucketlist.dao

import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import com.bucketlist.dto.PlaceInfo
import androidx.room.*

interface ILocalPlaceDAO {
    @Query("SELECT * FROM places")
    fun getAllPlants()  : LiveData<List<PlaceInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: ArrayList<PlaceInfo>)

    @Delete
    fun delete(plant: PlaceInfo)

    @Insert
    fun save(plant: PlaceInfo)
}