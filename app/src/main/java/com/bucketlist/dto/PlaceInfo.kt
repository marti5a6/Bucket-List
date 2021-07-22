package com.bucketlist.dto

data class PlaceInfo(var name: String = "", var formatted_address: String = "", var types : ArrayList<String>, var description : String = "", var place_id: String = "", var latitude: String="", var longitude: String = "") {
    override fun toString(): String {
        return "$name $formatted_address $latitude $longitude"
    }
}