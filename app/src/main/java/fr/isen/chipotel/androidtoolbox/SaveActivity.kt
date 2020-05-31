package fr.isen.chipotel.androidtoolbox
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_save.*
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class SaveActivity : AppCompatActivity() {

    companion object {
        val kFirstNameKey = "kFirstNameKey"
        val kLastNameKey = "kLastNameKey"
        val kBirthDay = "kBirthDay"
        val kFilename = "data.json"
    }

    var currentDate = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        button_save_to_json.setOnClickListener {
            save()
        }

        button_read.setOnClickListener {
            read()
        }

        birth_et.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus) {
                birth_et.clearFocus()
                val dialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        onDateChoose(year, month, dayOfMonth)
                    },
                    1995,
                    6,
                    15)
                dialog.show()
            }
        }
    }

    fun save() {
        if (first_name_et.text.toString().isNotEmpty() &&
            last_name_et.text.toString().isNotEmpty() &&
            birth_et.text.toString().isNotEmpty()) {
            val json = JSONObject()
            json.put(SaveActivity.kFirstNameKey, first_name_et.text.toString())
            json.put(SaveActivity.kLastNameKey, last_name_et.text.toString())
            json.put(SaveActivity.kBirthDay, birth_et.text.toString())
            Toast.makeText(this, json.toString(), Toast.LENGTH_LONG).show()

            val file = File(cacheDir.absolutePath+"/"+SaveActivity.kFilename)
            file.writeText(json.toString())

        } else {
            Toast.makeText(this, R.string.fields_empty, Toast.LENGTH_LONG).show()
        }
    }

    fun read() {
        val file = File(cacheDir.absolutePath+"/"+SaveActivity.kFilename)
        val readString = file.readText()
        val json = JSONObject(readString)
        val dateString = json.getString(SaveActivity.kBirthDay)
        val components = dateString.split("/")
        Toast.makeText(this,"vous avez ${getAge(components[2].toInt(), components[1].toInt(), components[0].toInt())} ans", Toast.LENGTH_LONG).show()
    }

    fun onDateChoose(year: Int, month: Int, day: Int) {
        birth_et.setText(String.format("%02d/%02d/%04d", day, month+1, year))
    }

    fun getAge(year: Int, month: Int, day: Int): Int {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val dateString = formatter.format(currentDate)
        val components = dateString.split("/")

        var age = components[2].toInt() - year
        if(components[1].toInt() < month) {
            age--
        } else if (components[1].toInt() == month &&
            components[0].toInt() < day){
            age --
        }
        return age
    }
}

