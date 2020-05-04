package fr.isen.chipotel.androidtoolbox

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("first_name") val first_name: String, @SerializedName("last_name") val last_name: String, @SerializedName("year") val year: Int ) {

}

