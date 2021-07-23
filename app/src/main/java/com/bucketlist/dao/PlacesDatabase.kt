package com.bucketlist.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bucketlist.dto.PlaceInfo

@Database(entities=arrayOf(PlaceInfo::class), version = 1)
abstract class PlacesDatabase : RoomDatabase() {
    abstract fun localPlantDAO() : ILocalPlaceDAO
}