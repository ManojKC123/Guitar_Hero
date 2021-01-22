package com.manoj.onlinebusticket

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogin.setOnClickListener {

            if (etPassword.text.toString() == "admin" && etUsername.text.toString() == "admin"){
                val intent = Intent(this@LoginActivity as Context, MainActivity::class.java)
                this@LoginActivity.startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(
                    this@LoginActivity as Context,
                    "Either Username or Password is Incorrect",
                    Toast.LENGTH_SHORT
                ).show()
                etUsername.error = "Username or Password is incorrect"
                etUsername.requestFocus()
            }
        }

    }
}