package com.shivam.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        },3100)

        showgif()

    }
    fun showgif(){

        val imageview:ImageView=findViewById(R.id.calc)
        Glide.with(this).load(R.drawable.calculatingbg).into(imageview)
    }
}