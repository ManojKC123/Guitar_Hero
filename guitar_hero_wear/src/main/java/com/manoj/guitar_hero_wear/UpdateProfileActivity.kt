package com.manoj.guitar_hero_wear

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.manoj.guitar_hero_wear.entity.User
import com.manoj.guitar_hero_wear.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var etfname: EditText
    private lateinit var etlname: EditText
    private lateinit var etemail: EditText
    private lateinit var etphone: EditText
    private lateinit var etaddress: EditText
    private lateinit var btnupdate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        etaddress=findViewById(R.id.etaddress)
        etemail=findViewById(R.id.etemail)
        etfname=findViewById(R.id.etfname)
        etlname=findViewById(R.id.etlname)
        etphone=findViewById(R.id.etphone)
        btnupdate=findViewById(R.id.btnupdate)
        loadUserDetails()
        btnupdate.setOnClickListener {
            updateUser()
        }
    }
    private fun updateUser(){
        val etfname=etfname.text.toString()
        val etlname=etlname.text.toString()
        val etmail=etemail.text.toString()
        val etphone=etphone.text.toString()
        val etaddress=etaddress.text.toString()

        val userdetails = User(firstname = etfname, lastname = etlname, email = etmail, phone = etphone, address = etaddress)

        CoroutineScope(Dispatchers.IO).launch{
            try{
                val userRepository = UserRepository()
                val response = userRepository.updateUser(userdetails)
                if (response.success == true){

                    withContext(Dispatchers.Main){
                        startActivity(
                            Intent(
                                this@UpdateProfileActivity,
                                MainActivity::class.java
                            )
                        )
                    }
                }
            }
            catch (ex:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@UpdateProfileActivity,
                        ex.toString(),
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
    private fun loadUserDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val userrepository = UserRepository()
                val response = userrepository.getUser()
                val success = response.success
                if (success == true) {
                    val userdata = response.data!!
//                    val imagepath = ServiceBuilder.loadImagePath() + userdata.imagepp
                    withContext(Dispatchers.Main) {
                        etphone.setText("${userdata.phone}")
                        etlname.setText("${userdata.lastname}")
                        etfname.setText("${userdata.firstname}")
                        etemail.setText("${userdata.email}")
                        etaddress.setText("${userdata.address}")


//                        Glide.with(requireContext())
//                            .load(imagepath)
//                            .fitCenter()
//                            .into(userimage)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@UpdateProfileActivity,
                        "Error: ${e.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}