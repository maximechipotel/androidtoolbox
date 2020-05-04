package fr.isen.chipotel.androidtoolbox

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inscription.*
import kotlinx.android.synthetic.main.activity_login.*

class InscriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        /*val pref = getPreferences(Context.MODE_PRIVATE)
        val identifiant = pref.getString("Identifiant ", "")
        val mdp = pref.getInt("MDP",0)
        inscription_ID_et.setText(identifiant)
        inscription_mdp_et.setText(mdp.toString())*/

    }


}
