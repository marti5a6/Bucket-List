package com.bucketlist.ui.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.bucketlist.R
import com.bucketlist.dto.BucketListItem

class MainFragment : Fragment() {

private val LOCATION_PERMISSION_REQUEST_CODE=2000
    private val NOTIFICATION_PERMISSION_CODE = 123

    private lateinit var viewModel: MainViewModel
    private lateinit var locationViewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        prepRequestLocationUpdates()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
    //private fun requestNotificationPermission(){
        //if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY) == PackageManager.PERMISSION_GRANTED)
            //return
        //if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY))
    //}


    fun prepRequestLocationUpdates(){
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            requestLocationUpdates()
        }else{
            val permissionRequest = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            requestPermissions(permissionRequest,LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    private fun requestLocationUpdates() {
        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
        locationViewModel.getLocationLiveData().observe(viewLifecycleOwner, Observer {
            it.latitude
            it.longitude
        })

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
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


    //inner class EventsAdapter (val events List <BucketListItem>, val itemLayout: Int)
//inner class EventViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    //private var imgEventThumbnail : ImageView = itemView.findViewById(R.id.imageEventThumbnail)
    //private var lblEventInfo: TextView = itemView.findViewById(R.id.lblEventInfo)

   // fun updatePlace (event: BucketListItem){
      //  lblEventInfo.text = event.toString()
   // }
//}
}