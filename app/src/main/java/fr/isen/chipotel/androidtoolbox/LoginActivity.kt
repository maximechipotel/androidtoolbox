package fr.isen.chipotel.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.chipotel.androidtoolbox.Models.Constants
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    var userPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
        checkPreferences()
        button_valider.setOnClickListener {
            doLogin()

        }
    }

    fun doLogin(){
        if (canLog(email_et.text.toString(), password_et.text.toString())){
            saveUser(email_et.text.toString(),password_et.text.toString())
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    fun canLog(identifier: String, password: String): Boolean {
        return identifier == Constants.goodIdentifier && password == Constants.goodPassword
    }

    fun saveUser(identifier: String, password: String){
        val editor = userPref?.edit()
        editor?.putString(Constants.kIdentifier, identifier)
        editor?.putString(Constants.kPassword, password)
        editor?.commit()
    }

    fun checkPreferences(){
        val identifier = userPref?.getString(Constants.kIdentifier, null) ?:""
        val password = userPref?.getString(Constants.kPassword, null) ?:""
        email_et.setText(identifier)
        password_et.setText(password)
        doLogin()
    }
}

