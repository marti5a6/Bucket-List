package com.bucketlist.ui.main


import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bucketlist.R
import com.bucketlist.dto.LocationDetails
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.Exception

@Suppress("DEPRECATION")
class MainFragment : Fragment() {

private val LOCATION_PERMISSION_REQUEST_CODE=2000

    private lateinit var viewModel: MainViewModel
    private lateinit var locationViewModel: LocationViewModel
    private lateinit var applicationViewModel: ApplicationViewModel

    var latitude: String="39.1031"
    var longitude: String="84.5120"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        applicationViewModel = ViewModelProviders.of(this).get(ApplicationViewModel::class.java)

        prepRequestLocationUpdates()

    }


    companion object {
        fun newInstance() = MainFragment()
    }

    fun prepRequestLocationUpdates(){
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            requestLocationUpdates()
        }else{
            val permissionRequest = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            requestPermissions(permissionRequest,LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    //the it.lat and it.long below should show the current location once permission is granted, i checked using breakpoints on them
    private fun requestLocationUpdates() {
        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
        locationViewModel.getLocationLiveData().observe(viewLifecycleOwner, Observer {
            it.latitude
            it.longitude
            latitude=it.latitude
            longitude=it.longitude
        })

        /*Could not resolve error with getLocationLiveData
        so hardcoding cincinnati for now
        * */
        //latitude="39.1031"
        //longitude="84.5120"
        /*applicationViewModel.getLocationLiveData().observe(viewLifecycleOwner, Observer {
            latitude= it.latitude
            longitude=  it.longitude
        })**/
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==  PackageManager.PERMISSION_GRANTED) {
                    requestLocationUpdates()
                } else {
                    Toast.makeText(context, "Unable to update location without permission", Toast.LENGTH_LONG).show()
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }


}