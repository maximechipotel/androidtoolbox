package fr.isen.chipotel.androidtoolbox

import com.google.gson.Gson
import junit.framework.Assert.assertEquals
import org.junit.Test

class UserTest {
    @Test
    fun userToJson(){
        val user: User = User("Maxime", "CHIPOTEL", 1998)
        val json = Gson().toJson(user)
        println(json)
        //assertEquals()

    }


    @Test
    fun jsonToUser(){
        val json = "{\"first_name\":\"Maxime\", \"last_name\":\"CHIPOTEL\",\"year\":1998}"
        val user = Gson().fromJson(json, User::class.java)
        //println(user)

    }
}