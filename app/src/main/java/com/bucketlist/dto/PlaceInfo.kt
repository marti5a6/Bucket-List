package com.bucketlist.dto

data class PlaceInfo(var name: String = "", var formatted_address: String = "", var description : String = "", var place_id: String = "", var latitude: String="", var longitude: String = "") {
    //var types : ArrayList<String>

    fun getPlaceName(): String{
        return "$name"
    }
    fun getPlaceCoordinates(): String{
       // return "$latitude $longitude"
        return "$formatted_address"
    }
    fun getLong(): String{
        return "$longitude"
    }
    fun getLat(): String{
        return "$latitude"
    }
    override fun toString(): String {
        return "$name $formatted_address $latitude $longitude"
    }
}