package com.bucketlist.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="bucketlistitem")
data class BucketListItem(var name: String = "", @PrimaryKey var itemID: Int = 0) {
    override fun toString(): String {
        return name
    }
}
