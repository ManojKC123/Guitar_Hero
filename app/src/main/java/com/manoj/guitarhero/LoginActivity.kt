package com.manoj.guitarhero

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.manoj.guitarhero.db.OnlineBusTicketDB
import com.manoj.guitarhero.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.EditText_email)
        etPassword = findViewById(R.id.EditText_password)
        btnLogin = findViewById(R.id.loginbtn)
        btnSignUp = findViewById(R.id.signupbtn)

        btnLogin.setOnClickListener {
            login()
        }

        btnSignUp.setOnClickListener(
            View.OnClickListener
        { startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        })



    }
    private fun login(){
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        var user: User? = null
        CoroutineScope(Dispatchers.IO).launch {
            user = OnlineBusTicketDB
                    .getInstance(this@LoginActivity)
                    .getUserDao()
                    .checkUser(username,password)
            if (user == null){
                withContext(Main){
                    Toast.makeText(this@LoginActivity,
                    "Invalid Credentials!!!", Toast.LENGTH_SHORT)
                            .show()
                }
            }
            else{

                withContext(Main){
                    saveSharedPref(username,password)
                    Toast.makeText(this@LoginActivity,
                            "Login Successful !!!", Toast.LENGTH_SHORT)
                            .show()
                }
                startActivity(
                        Intent(
                                this@LoginActivity,
                                MainActivity::class.java
                        )
                )
            finish()
            }
        }
    }

   private fun saveSharedPref(username:String, password:String){
        val sharedPref = getSharedPreferences("AppPref",
                Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("password", password)

        editor.apply()
    }
}