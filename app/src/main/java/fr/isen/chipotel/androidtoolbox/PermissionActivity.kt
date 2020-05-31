package fr.isen.chipotel.androidtoolbox



import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.chipotel.androidtoolbox.Models.Constants
import kotlinx.android.synthetic.main.activity_permission.*



class PermissionActivity : AppCompatActivity(), LocationListener{

    companion object {
        val contactPermissionRequestCode = 2
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        Log.d("gps","onStatusChanged")
    }

    override fun onProviderEnabled(provider: String?) {
        Log.d("gps","onProviderEnabled")
    }

    override fun onProviderDisabled(provider: String?) {
        Log.d("gps","onProviderDisabled")
    }

    private lateinit var locationManager : LocationManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        replaceButton.setOnClickListener {
            cameraGallery()
        }

        requestPermission(android.Manifest.permission.READ_CONTACTS, contactPermissionRequestCode) {
            readContacts()
        }

        locationButton.setOnClickListener{
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null)
                //locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

            }

            else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 12)
                Toast.makeText(this, "Enable location", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onLocationChanged(location: Location?) {
        Toast.makeText(this, location?.longitude.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == Constants.REQUEST_CODE ) {
            if (data?.data != null) {
                replaceButton.setImageURI(data.data)
            }
            else{
                val imageBitmap = data?.extras?.get("data") as? Bitmap
                replaceButton.setImageBitmap(imageBitmap)
            }

        }
    }

    private fun cameraGallery(){
        val galeryIntent = Intent(Intent.ACTION_PICK)
        galeryIntent.type = "image/"

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val intentChoose = Intent.createChooser(galeryIntent, "Gallery")
        intentChoose.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
        startActivityForResult(intentChoose, Constants.REQUEST_CODE)
    }

    fun requestPermission(permissionToRequest: String, requestCode: Int, handler: ()-> Unit) {
        if(ContextCompat.checkSelfPermission(this, permissionToRequest) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissionToRequest)) {
                //display toast
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(permissionToRequest), requestCode)
            }
        } else {
            handler()
        }
    }

    fun readContacts() {
        val contactList = ArrayList<ContactModel>()
        val contacts = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        while(contacts?.moveToNext() ?: false) {
            val displayName = contacts?.getString(contacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            val contactModel = ContactModel()
            contactModel.displayName = displayName.toString()
            contactList.add(contactModel)
        }
        contactRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        contactRecyclerView.adapter = ContactsAdapter(contactList)
    }

}