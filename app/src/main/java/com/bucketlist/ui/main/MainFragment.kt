package com.bucketlist.ui.main

import android.Manifest
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bucketlist.R
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val LOCATION_PERMISSION_REQUEST_CODE = 2000

    private lateinit var permissionsManager: PermissionsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
    var permissionsListener: PermissionsListener = object : PermissionsListener {
        override fun onExplanationNeeded(permissionsToExplain: List<String>) {

        }

        override fun onPermissionResult(granted: Boolean) {
            if (granted) {

                // Permission sensitive logic called here, such as activating the Maps SDK's LocationComponent to show the device's location

//                val locationComponentOptions = LocationComponentOptions.builder(this)
//                    .layerBelow(layerId)
//                    .foregroundDrawable(R.drawable.drawable_name)
//                    .bearingTintColor(int color)
//                    .accuracyAlpha(float)
//                    .build()
//
//                val locationComponentActivationOptions = LocationComponentActivationOptions
//                    .builder(this, style)
//                    .locationComponentOptions(locationComponentOptions)
//                    .build()
//
//                locationComponent = mapboxMap.locationComponent
//                locationComponent.activateLocationComponent(locationComponentActivationOptions)

            } else {

                // User denied the permission

            }
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if (PermissionsManager.areLocationPermissionsGranted(this.context)) {

// Permission sensitive logic called here, such as activating the Maps SDK's LocationComponent to show the device's location

        } else {
            permissionsManager = PermissionsManager(permissionsListener)
            permissionsManager.requestLocationPermissions(this.activity)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


}