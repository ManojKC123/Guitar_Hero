package com.manoj.guitarhero

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
//import com.manoj.guitarhero.db.GuitarHeroDB
import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpActivity : AppCompatActivity() {
    private lateinit var etfname : EditText
    private lateinit var etlname : EditText
    private lateinit var etmobile : EditText
    private lateinit var etaddress : EditText
    private lateinit var etmailid : EditText
    private lateinit var etpassword : EditText
    private lateinit var etConfirmPassword : EditText
    private lateinit var btnSignUp : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = Notification(this)

        etfname = findViewById(R.id.fname)
        etlname = findViewById(R.id.lname)
        etmobile = findViewById(R.id.etnumber)
        etaddress = findViewById(R.id.address)
        etmailid = findViewById(R.id.mailId)
        etpassword = findViewById(R.id.pass1)
        etConfirmPassword = findViewById(R.id.pass2)
        btnSignUp = findViewById(R.id.submit)

        btnSignUp.setOnClickListener{
            val firstname = etfname.text.toString()
            val lastname = etlname.text.toString()
            val phone = etmobile.text.toString()
            val address = etaddress.text.toString()
            val email = etmailid.text.toString()
            val password = etpassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()


            if(password != confirmPassword){
                etpassword.error = "Password does not Match"
                etpassword.requestFocus()
                return@setOnClickListener
            }else{
                val user = User(firstname=firstname, lastname=lastname, phone=phone, address=address, email=email, password=password )

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val userRepository = UserRepository()
                        val response = userRepository.registerUser(user)
                        if (response.success == true) {
                            withContext(Main) {
                                Toast.makeText(
                                        this@SignUpActivity,
                                        "Register Successful",
                                        Toast.LENGTH_SHORT
                                ).show()
                                startActivity(
                                        Intent(
                                                this@SignUpActivity,
                                                LoginActivity::class.java
                                        )
                                )
                                finish()
                            }
                        }
                    }
                    catch (ex: Exception){
                        withContext(Main){
                            Toast.makeText(this@SignUpActivity, ex.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }


    }
}