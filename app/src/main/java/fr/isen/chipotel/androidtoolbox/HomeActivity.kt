package fr.isen.chipotel.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

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
    }
}
