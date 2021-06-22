package com.bucketlist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bucketlist.dto.BucketListItem

class MainViewModel : ViewModel() {
    //Use of Array list to get and set bucket list items
    private var _bucketlistitems: MutableLiveData<ArrayList<BucketListItem>> = MutableLiveData<ArrayList<BucketListItem>>()
    var bucketlistitems:MutableLiveData<ArrayList<BucketListItem>>
        get () {return _bucketlistitems}
        set (value) {_bucketlistitems = value}
}

