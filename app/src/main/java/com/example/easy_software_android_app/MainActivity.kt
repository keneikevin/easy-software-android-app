package com.example.easy_software_android_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easy_software_android_app.Constants.BASE_URL
import com.example.easy_software_android_app.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}

















