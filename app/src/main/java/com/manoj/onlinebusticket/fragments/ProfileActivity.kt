package com.manoj.onlinebusticket.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.manoj.onlinebusticket.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)
        etUsername = findViewById(R.id.EditText_email)
        etPassword = findViewById(R.id.EditText_password)
        btnLogin = findViewById(R.id.loginbtn)
        btnSignUp= findViewById(R.id.signupbtn)

    }
}