package com.bucketlist.ui.main

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bucketlist.dto.BucketListItem

class MainViewModel : ViewModel() {
    private var _bucketListItems: MutableLiveData<ArrayList<BucketListItem>> = MutableLiveData<ArrayList<BucketListItem>>()

    internal var bucketListItems:MutableLiveData<ArrayList<BucketListItem>>
        get () {return _bucketListItems}
        set (value) {_bucketListItems = value}
}
