package fr.isen.chipotel.androidtoolbox

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("first_name") val first_name: String, @SerializedName("last_name") val last_name: String, @SerializedName("year") val year: Int ) {

}// à supprimer


//utiliser le write to json

//ecrire le chemin de dispo pour le tel
//utiliser le cashdire exemple user_data.json


//parse en json, getopt -> pour récupérer chaque clef.
