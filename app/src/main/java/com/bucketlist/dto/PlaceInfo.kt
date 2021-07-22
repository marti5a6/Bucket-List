package com.bucketlist.dto

data class PlaceInfo(var name: String = "", var formatted_address: String = "", var description : String = "", var place_id: String = "", var latitude: String="", var longitude: String = "") {
    //var types : ArrayList<String>

    fun getPlaceName(): String{
        return "$name"
    }
    fun getPlaceCoordinates(): String{
        return "$latitude $longitude"
    }
    override fun toString(): String {
        return "$name $formatted_address $latitude $longitude"
    }
}