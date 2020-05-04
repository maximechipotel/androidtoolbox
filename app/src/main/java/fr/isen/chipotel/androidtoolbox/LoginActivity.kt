package fr.isen.chipotel.androidtoolbox

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        button_valider.setOnClickListener {

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

        button_inscription.setOnClickListener{
            val intent = Intent(this, InscriptionActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        val pref = getPreferences(Context.MODE_PRIVATE)
        val email = pref.getString("email ", "")
        val password = pref.getInt("password",0)

        email_et.setText(email)
        password_et.setText(password.toString())
    }

    fun onSave(view: View) {

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString("email", email_et.text.toString())
        editor.putInt("password", password_et.text.toString().toInt())
        //commit change
        editor.commit()

        val toast = Toast.makeText(applicationContext, "Enregistrer",Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP,0,200)
        toast.show()

    }

    fun onClear(view: View) {
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()

        email_et.setText("")
        password_et.setText("")
    }
}
