package com.manoj.onlinebusticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    private lateinit var anim : Animation
    private lateinit var splashimg : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashimg = findViewById(R.id.imageView2)
        anim = AnimationUtils.loadAnimation(applicationContext,
                R.anim.fade_in);
        anim.run {
            setAnimationListener(object :AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(
                        Intent(
                                this@SplashActivity,
                                LoginActivity::class.java
                        ))
            }

            override fun onAnimationStart(animation: Animation?) {
                TODO("Not yet implemented")
            }

        });
            splashimg.startAnimation(anim)
        }


    }





}


