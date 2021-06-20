package com.bucketlist.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bucketlist.dto.BucketListItem

@Database(entities = arrayOf(BucketListItem::class), version = 1)
abstract class BucketListItemDatabase : RoomDatabase() {
    abstract fun localBucketListItemDAO() : ILocalBucketListItemDAO
}