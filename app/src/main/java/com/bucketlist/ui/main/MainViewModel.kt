package com.bucketlist.ui.main

import android.app.Application
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
    private var _bucketListItems: MutableLiveData<ArrayList<BucketListItem>> = MutableLiveData<ArrayList<BucketListItem>>()

    internal var bucketlistitems:MutableLiveData<ArrayList<BucketListItem>>
        get () {return _bucketlistitems}
        set (value) {_bucketlistitems = value}


    /*
    use coroutine to fetch places data to be used for storing locally
    * */
    fun getPlaces(location: String, cat: String){
        viewModelScope.launch {
            _placeService.fetchPlaces(location, cat)
        }
    }
       // get () {return _bucketListItems}
       // set (value) {_bucketListItems = value}
}
