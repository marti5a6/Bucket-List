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
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bucketlist.R
import com.bucketlist.databinding.MainActivityBinding
import com.bucketlist.dto.LocationDetails
import com.bucketlist.dto.PlaceInfo
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.Exception

class MainFragment : Fragment() {

private val LOCATION_PERMISSION_REQUEST_CODE=2000

    private lateinit var viewModel: MainViewModel
    private lateinit var applicationViewModel: ApplicationViewModel
    private lateinit var binding: MainActivityBinding
    private var _places = ArrayList<PlaceInfo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        applicationViewModel = ViewModelProviders.of(this).get(ApplicationViewModel::class.java)


//        applicationViewModel.placeService.getLocalPlaceDAO().fetchPlaces().observe(this, Observer {
//
//        })

        prepRequestLocationUpdates()

        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = PlaceInfoAdapter(_places, R.layout.rowlayout)

    }


    companion object {
        fun newInstance() = MainFragment()
    }

   // fun prepRequestLocationUpdates(){
     //   if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
       //     requestLocationUpdates()
        //}else{
          //  val permissionRequest = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            //requestPermissions(permissionRequest,LOCATION_PERMISSION_REQUEST_CODE)
        //}
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

        /*Could not resolve error with getLocationLiveData
        so hardcoding cincinnati for now
        * */
        //latitude="39.1031"
        //longitude="84.5120"
        applicationViewModel.getLocationLiveData().observe(viewLifecycleOwner, Observer {
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
    inner class PlaceInfoAdapter(val places: List<PlaceInfo>,val itemLayout: Int) : RecyclerView.Adapter<PlaceViewHolder>(){
        /**
         * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
         * an item.
         *
         *
         * This new ViewHolder should be constructed with a new View that can represent the items
         * of the given type. You can either create a new View manually or inflate it from an XML
         * layout file.
         *
         *
         * The new ViewHolder will be used to display items of the adapter using
         * [.onBindViewHolder]. Since it will be re-used to display
         * different items in the data set, it is a good idea to cache references to sub views of
         * the View to avoid unnecessary [View.findViewById] calls.
         *
         * @param parent The ViewGroup into which the new View will be added after it is bound to
         * an adapter position.
         * @param viewType The view type of the new View.
         *
         * @return A new ViewHolder that holds a View of the given view type.
         * @see .getItemViewType
         * @see .onBindViewHolder
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
            return PlaceViewHolder(view)
        }

        /**
         * Called by RecyclerView to display the data at the specified position. This method should
         * update the contents of the [ViewHolder.itemView] to reflect the item at the given
         * position.
         *
         *
         * Note that unlike [android.widget.ListView], RecyclerView will not call this method
         * again if the position of the item changes in the data set unless the item itself is
         * invalidated or the new position cannot be determined. For this reason, you should only
         * use the `position` parameter while acquiring the related data item inside
         * this method and should not keep a copy of it. If you need the position of an item later
         * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
         * have the updated adapter position.
         *
         * Override [.onBindViewHolder] instead if Adapter can
         * handle efficient partial bind.
         *
         * @param holder The ViewHolder which should be updated to represent the contents of the
         * item at the given position in the data set.
         * @param position The position of the item within the adapter's data set.
         */
        override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
            val place = places.get(position)
            holder.updatePlaceInfo(place)
        }

        /**
         * Returns the total number of items in the data set held by the adapter.
         *
         * @return The total number of items in this adapter.
         */
        override fun getItemCount(): Int {
            return places.size
        }

    }

    inner class PlaceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var lblName: TextView = itemView.findViewById(R.id.lblName)
        private var lblCoordinates: TextView = itemView.findViewById(R.id.lblCoordinates)


        fun updatePlaceInfo(placeInfo: PlaceInfo) {
            placeInfo.getPlaceName()
            placeInfo.getPlaceCoordinates()
        }
    }
}