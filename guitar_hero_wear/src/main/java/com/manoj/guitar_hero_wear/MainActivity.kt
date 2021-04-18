package com.manoj.guitar_hero_wear

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import com.manoj.guitar_hero_wear.api.ServiceBuilder
import com.manoj.guitar_hero_wear.repository.UserRepository
import com.manoj.guitar_hero_wear.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : WearableActivity() {
    private lateinit var tv_name: TextView
    private lateinit var tv_fname: TextView
    private lateinit var tv_lname: TextView
    private lateinit var tv_email: TextView
    private lateinit var tv_phone: TextView
    private lateinit var tv_address: TextView
    private lateinit var img_setting: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_name = findViewById(R.id.tv_name)
        tv_fname = findViewById(R.id.tv_fname)
        tv_lname = findViewById(R.id.tv_lname)
        tv_email = findViewById(R.id.tv_email)
        tv_phone = findViewById(R.id.tv_phone)
        tv_address = findViewById(R.id.tv_address)
        img_setting = findViewById(R.id.img_setting)
        img_setting.setOnClickListener {
            loadPopUpMenu()
        }


        CoroutineScope(Dispatchers.IO).launch {
            try {
                val userrepository = UserRepository()
                val response = userrepository.getUser()
                val success = response.success
                if (success == true) {
                    val userdata = response.data!!
//                    val imagepath = ServiceBuilder.loadImagePath() + userdata.imagepp
                    withContext(Dispatchers.Main) {
                        tv_name.text = userdata.firstname + " " + userdata.lastname
                        tv_email.text = userdata.email
                        tv_fname.text = userdata.firstname
                        tv_lname.text = userdata.lastname
                        tv_phone.text = userdata.phone
                        tv_address.text = userdata.address

//                        Glide.with(requireContext())
//                            .load(imagepath)
//                            .fitCenter()
//                            .into(userimage)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@MainActivity,
                            "Error: ${e.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }




    }
    private fun loadPopUpMenu() {
        val popupMenu = PopupMenu(this!!, img_setting)
        popupMenu.menuInflater.inflate(R.menu.update_logout, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menuupdateprofile ->loadupdatefragment()
                R.id.menulogout ->logout()


            }
            true
        }
        popupMenu.show()
    }

    private fun loadupdatefragment(){
        val intent = Intent(this, UpdateProfileActivity::class.java)
        this?.startActivity(intent)
    }
    private fun logout(){
        val sharedPref = this?.getSharedPreferences("AppPref", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.clear()
        editor?.apply()
        ServiceBuilder.token.equals("")
        startActivity(
                Intent(
                        this,
                        LoginActivity::class.java
                )
        )
        this?.finish()

    }
}