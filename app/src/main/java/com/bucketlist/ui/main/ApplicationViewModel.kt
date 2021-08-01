package com.bucketlist.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bucketlist.service.PlaceService

class ApplicationViewModel (application: Application) : AndroidViewModel(application){

    private var _placeService: PlaceService = PlaceService(application)
    private val locationLiveData = LocationLiveData(application)
    internal fun getLocationLiveData() = locationLiveData

    internal var placeService : PlaceService
        get() {return _placeService}
        set(value) {_placeService = value}
}