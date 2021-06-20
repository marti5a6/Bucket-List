package com.bucketlist.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bucketlist.dto.BucketListItem

@Dao
interface ILocalBucketListItemDAO {
    @Query("SELECT * FROM bucketlistitem")
    fun getAll()  : LiveData<List<BucketListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bucketlistitems: BucketListItem)

    @Delete
    fun delete(bucketlistitem: BucketListItem)

    @Insert
    fun save(bucketlistitem: BucketListItem)
}