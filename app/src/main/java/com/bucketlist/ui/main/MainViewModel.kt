package com.bucketlist.ui.main

import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class MainViewModel : ViewModel() {
    internal var bucketitems:MutableLiveData<ArrayList<BucketItem>>
        get () {return _bucketitems}
        set (value) {_bucketitems = value}
}