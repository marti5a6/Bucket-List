package com.bucketlist.ui.main

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bucketlist.dto.BucketListItem

class MainViewModel : ViewModel() {
    //Use of Array list to get and set bucket list items
    private var _bucketlistitems: MutableLiveData<ArrayList<BucketListItem>> = MutableLiveData<ArrayList<BucketListItem>>()
    internal var bucketlistitems:MutableLiveData<ArrayList<BucketListItem>>
        get () {return _bucketlistitems}
        set (value) {_bucketlistitems = value}
}
