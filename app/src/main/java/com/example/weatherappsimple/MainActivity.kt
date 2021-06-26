package com.example.weatherappsimple

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import pojo.GeneralInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGetWeather.setOnClickListener {
            if (editTextEnterCity.text.toString().isNotEmpty()) {
                val intent = Intent(this, GeneralInformationActivity::class.java).apply {
                    putExtra("city", editTextEnterCity.text.toString())
                }
                startActivity(intent)
            }
        }

    }
}