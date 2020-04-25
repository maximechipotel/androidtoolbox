package fr.isen.chipotel.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_valider.setOnClickListener() {
            Toast.makeText(applicationContext,R.string.toast_valider,Toast.LENGTH_LONG).show()
        }
    }
}
