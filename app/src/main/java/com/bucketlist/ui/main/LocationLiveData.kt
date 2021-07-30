package com.bucketlist.ui.main

import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import com.bucketlist.dto.LocationDetails
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationCallback

class LocationLiveData(context : Context): LiveData<LocationDetails>() {

    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    override fun onInactive() {
        super.onInactive()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }
    override fun onActive(){
        super.onActive()
        fusedLocationClient.lastLocation.addOnSuccessListener {
            location: Location -> location.also{
             setLocationData(it)
        }
        }
    }

    private fun startLocationUpdates(){
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
    }

    private val locationCallback = object: LocationCallback() {
       override fun onLocationResult(locationResult: LocationResult?){
            super.onLocationResult(locationResult)
            locationResult ?: return
            for(location in locationResult.locations){
                setLocationData(location)
            }
       }
    }

    private fun setLocationData(location: Location?) {
        value = LocationDetails(location?.latitude.toString(),location?.longitude.toString())
    }

    companion object{
        val ONE_MINUTE : Long = 60000
        val locationRequest : LocationRequest = LocationRequest.create().apply{
            interval = ONE_MINUTE
            fastestInterval = ONE_MINUTE/4
            priority = LocationRequest.PRIORITY_LOW_POWER
        }
    }
}