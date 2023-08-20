package com.example.app_avatar.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app_avatar.LoginActivity
import com.example.app_avatar.MainActivity
import com.example.app_avatar.R
import com.example.app_avatar.databinding.ActivitySplashScren1Binding

class SplashScren1Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScren1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySplashScren1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.btnsplash.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }



}