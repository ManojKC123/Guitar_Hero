package com.manoj.guitarhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var imageView: ImageView
    private lateinit var tvlogo: TextView
    private lateinit var tvslogan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageView = findViewById(R.id.imageView)
        tvlogo = findViewById(R.id.textView3)
        tvslogan = findViewById(R.id.textView4)

        imageView.animation = topAnim;
        tvlogo.animation = bottomAnim;
        tvslogan.animation = bottomAnim;

        Handler().postDelayed({
            startActivity(
                    Intent(
                            this@SplashActivity,
                            LoginActivity::class.java
                    )
            )
        },3000)


    }
}






