package com.manoj.guitarhero

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar
import com.manoj.guitarhero.api.ServiceBuilder
//import com.manoj.guitarhero.db.GuitarHeroDB
import com.manoj.guitarhero.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity() : AppCompatActivity() {

    private val permissions = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION
    )


    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var checkremember: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.EditText_email)
        etPassword = findViewById(R.id.EditText_password)
        btnLogin = findViewById(R.id.loginbtn)
        btnSignUp = findViewById(R.id.signupbtn)
        linearLayout = findViewById(R.id.linearLayout)
        checkremember=findViewById(R.id.chkRememberMe)

        checkRunTimePermission()

        btnLogin.setOnClickListener {
            login()
        }

        btnSignUp.setOnClickListener(
            View.OnClickListener
        { startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        })


    }

    private fun checkRunTimePermission() {
        if (!hasPermission()) {
            requestPermission()
        }
    }


    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                            this,
                            permission
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
                break
            }
        }
        return hasPermission
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@LoginActivity, permissions, 1)
    }

    private fun login(){
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = Notification(this)
        notificationChannels.createNotificationChannels()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                   ServiceBuilder.token = "Bearer " + response.token
                    saveSharedPref()
                    val notification = NotificationCompat.Builder(this@LoginActivity, notificationChannels.CHANNEL_1)
                        .setSmallIcon(R.drawable.notification)
                        .setContentTitle(response.message)
                        .setColor(Color.GREEN)
                        .build()
                    notificationManager.notify(1, notification)
                    startActivity(
                            Intent(
                                    this@LoginActivity,
                                    MainActivity::class.java
                            )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                                Snackbar.make(
                                        linearLayout,
                                        "Invalid credentials",
                                        Snackbar.LENGTH_LONG
                                )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@LoginActivity,
                            "Login error", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

   private fun saveSharedPref(){
       val username = etUsername.text.toString()
       val password = etPassword.text.toString()
       if (checkremember.isChecked){
           val sharedPref = getSharedPreferences("AppPref",
               Context.MODE_PRIVATE)
           val editor = sharedPref.edit()
           editor.putString("email", username)
           editor.putString("password", password)
           editor.apply()
       }

    }
}