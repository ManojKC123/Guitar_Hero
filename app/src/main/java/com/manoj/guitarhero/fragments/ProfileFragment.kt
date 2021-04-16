package com.manoj.guitarhero.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.manoj.guitarhero.*
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {
    private lateinit var tv_name: TextView
    private lateinit var tv_fname: TextView
    private lateinit var tv_lname: TextView
    private lateinit var tv_email: TextView
    private lateinit var tv_phone: TextView
    private lateinit var tv_address: TextView
    private lateinit var img_setting: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        tv_name = view.findViewById(R.id.tv_name)
        tv_fname = view.findViewById(R.id.tv_fname)
        tv_lname = view.findViewById(R.id.tv_lname)
        tv_email = view.findViewById(R.id.tv_email)
        tv_phone = view.findViewById(R.id.tv_phone)
        tv_address = view.findViewById(R.id.tv_address)
        img_setting = view.findViewById(R.id.img_setting)

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
                            context,
                            "Error: ${e.toString()}", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }


            return view
        }

        // Load pop up menu
        private fun loadPopUpMenu() {
            val popupMenu = PopupMenu(context!!, img_setting)
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
            val intent = Intent(context, UpdateProfileActivity::class.java)
            context?.startActivity(intent)
        }
    private fun logout(){
            val sharedPref = activity?.getSharedPreferences("AppPref",AppCompatActivity.MODE_PRIVATE)
            val editor = sharedPref?.edit()
            editor?.clear()
            editor?.apply()
            ServiceBuilder.token.equals("")
            notification()
            startActivity(
                    Intent(
                            context,
                            LoginActivity::class.java
                    )
            )
        activity?.finish()

    }

    private fun notification(){
        val notificationManager = NotificationManagerCompat.from(context!!)
        val notificationChannels = Notification(context!!)
        notificationChannels.createNotificationChannels()
        val notification = NotificationCompat.Builder(context!!, notificationChannels.CHANNEL_1)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("LogOut Successful !!!")
                .setColor(Color.GREEN)
                .build()
        notificationManager.notify(1, notification)
    }

    }