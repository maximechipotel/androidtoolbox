package fr.isen.chipotel.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_valider.setOnClickListener {
           // var status=if(email_et.text.toString().equals("admin")
           //     && password_et.text.toString().equals("123")) "Bienvenu" else "Mot de passe ou nom d'utilisateur incorrect"
            //Toast.makeText(this,status,Toast.LENGTH_LONG).show()

            if(email_et.text.toString().equals("admin")
                && password_et.text.toString().equals("123"))
            {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Bienvenue",Toast.LENGTH_LONG).show()
            }

            else
                Toast.makeText(this,"Mot de passe ou email incorrect",Toast.LENGTH_LONG).show()

        }
    }
}
