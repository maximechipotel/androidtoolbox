package fr.isen.chipotel.androidtoolbox


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    val UserPreferencesName = "UserPreferencesName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        button_cycle.setOnClickListener() {
            val intent = Intent(this, CycleActivity::class.java)
            startActivity(intent)
        }

        button_sauvegarde.setOnClickListener{
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }


        button_log_out.setOnClickListener {
            val userPref = getSharedPreferences(UserPreferencesName, Context.MODE_PRIVATE)
            val editor = userPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        button_permission.setOnClickListener{
            val intent = Intent(this, PermissionActivity::class.java)
            startActivity(intent)
        }

        button_webservices.setOnClickListener{
            val intent = Intent(this, WebServicesActivity::class.java)
            startActivity(intent)
        }
    }
}
