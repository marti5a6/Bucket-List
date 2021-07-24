package com.bucketlist.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="bucketListItem")

/**
* @param name: What the bucket list item is called
* @param itemID: Unique Identifier of this bucket list item.
* */

data class BucketListItem(var name: String = "", @PrimaryKey var itemID: Int = 0) {
    override fun toString(): String {
        return name
    }
}
