package fr.isen.chipotel.androidtoolbox


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_save.*


class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)


        button_save_json.setOnClickListener(){
            val first_name = findViewById<EditText>(R.id.first_name_et)
            val first_nameValue = first_name.text

            val last_name = findViewById<EditText>(R.id.last_name_et)
            val last_nameValue = last_name.text

            val year = findViewById<EditText>(R.id.birth_et)
            val yearValue = year.text

            val user: User = User(first_nameValue, last_nameValue, yearValue)
            val json = Gson().toJson(user)

        }

        }
}


