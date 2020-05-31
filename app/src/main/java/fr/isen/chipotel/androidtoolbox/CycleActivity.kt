package fr.isen.chipotel.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast


class CycleActivity : AppCompatActivity(), OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle)

        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, firstFragment).commit()

    }


    override fun onPause (){
        super.onPause()
        Log.d("thomas","Tache de fond")
    }

    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this, "Cycle destroyed",Toast.LENGTH_LONG).show()
    }

    override fun swipeFragment() {
        val secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, secondFragment).commit()
    }
}