package fr.isen.chipotel.androidtoolbox


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


class CycleActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true;
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle)
        //print("OnCreate")
        //Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()

        val Change = findViewById<Button>(R.id.button_fragment)
        ShowFragmentOne()
        Change.setOnClickListener {
            if (isFragmentOneLoaded)
                ShowFragmentTwo()
            else
                ShowFragmentOne()
        }

    }

    fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    fun ShowFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }
}


/* override fun onStart() {
     super.onStart()
     print("OnStart")
     Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show()
 }

 override fun onResume() {
     super.onResume()
     print("onResume")
     Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
 }

 override fun onPause() {
     super.onPause()
     print("onPause")
 }

 override fun onStop() {
     super.onStop()
     print("onStop")
 }

 override fun onRestart() {
     super.onRestart()
     print("onRestart")
     Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
 }

 override fun onDestroy() {
     super.onDestroy()
     print("Destroy")
 }
 fun print(msg: String){
     Log.d("Activity state",msg)

 }
*/

