package com.bucketlist.ui.main

import android.app.Application
import android.content.ContentValues.TAG
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bucketlist.dto.BucketListItem
import com.bucketlist.dto.PlaceInfo
import com.bucketlist.service.PlaceService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _bucketlistitems: MutableLiveData<ArrayList<BucketListItem>> = MutableLiveData<ArrayList<BucketListItem>>()
    var _placeService : PlaceService = PlaceService(application = Application())
    //private var _bucketListItems: MutableLiveData<ArrayList<BucketListItem>> = MutableLiveData<ArrayList<BucketListItem>>()
    private var _placeslist: MutableLiveData<ArrayList<PlaceInfo>> = MutableLiveData<ArrayList<PlaceInfo>>()
    internal var bucketlistitems:MutableLiveData<ArrayList<BucketListItem>>
        get () {return _bucketlistitems}
        set (value) {_bucketlistitems = value}

    internal var placeslist: MutableLiveData<ArrayList<PlaceInfo>>
        get () {return _placeslist}
        set (value) {_placeslist = value}

    /*
    use coroutine to fetch places data to be used for storing locally
    * */
    fun getPlaces(name: String){
        viewModelScope.launch {
            _placeService.fetchPlaces(name)
        }
    }
       // get () {return _bucketListItems}
       // set (value) {_bucketListItems = value}
}
