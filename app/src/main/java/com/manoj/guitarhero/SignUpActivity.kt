package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.manoj.guitarhero.db.OnlineBusTicketDB
import com.manoj.guitarhero.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpActivity : AppCompatActivity() {
    private lateinit var etname : EditText
    private lateinit var etmobile : EditText
    private lateinit var etaddress : EditText
    private lateinit var etmailid : EditText
    private lateinit var etpassword : EditText
    private lateinit var etConfirmPassword : EditText
    private lateinit var btnSignUp : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        etname = findViewById(R.id.name)
        etmobile = findViewById(R.id.number)
        etaddress = findViewById(R.id.address)
        etmailid = findViewById(R.id.mailId)
        etpassword = findViewById(R.id.pass1)
        etConfirmPassword = findViewById(R.id.pass2)
        btnSignUp = findViewById(R.id.submit)

        btnSignUp.setOnClickListener{
            val name = etname.text.toString()
            val mobile = etmobile.text.toString()
            val address = etaddress.text.toString()
            val mailID = etmailid.text.toString()
            val password = etpassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if(password != confirmPassword){
                etpassword.error = "Password does not Match"
                etpassword.requestFocus()
                return@setOnClickListener
            }else{
                val user = User(name, mobile, address, mailID, password)

                CoroutineScope(Dispatchers.IO).launch {
                    OnlineBusTicketDB
                        .getInstance(this@SignUpActivity)
                        .getUserDao()
                        .registerUser(user)

                    withContext(Main){
                        Toast.makeText(
                            this@SignUpActivity,
                            "User Registered Successfully!!!", Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        }


    }
}