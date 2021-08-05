package com.bucketlist.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val locationLiveData = LocationLiveData(application)
    fun getLocationLiveData() = locationLiveData
}