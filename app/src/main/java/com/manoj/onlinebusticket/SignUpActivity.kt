package com.manoj.onlinebusticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignUpActivity : AppCompatActivity() {
    private lateinit var etname : EditText
    private lateinit var etmobile : EditText
    private lateinit var etaddress : EditText
    private lateinit var etmailid : EditText
    private lateinit var etpassword : EditText
    private lateinit var btnSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        etname = findViewById(R.id.name)
        etmobile = findViewById(R.id.number)
        etaddress = findViewById(R.id.address)
        etmailid = findViewById(R.id.mailId)
        etpassword = findViewById(R.id.pass)
        btnSignUp = findViewById(R.id.submit)

    }
}