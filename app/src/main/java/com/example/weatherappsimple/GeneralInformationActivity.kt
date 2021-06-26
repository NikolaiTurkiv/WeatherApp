package com.example.weatherappsimple

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_general_information.*
import kotlinx.android.synthetic.main.activity_main.*
import pojo.GeneralInformation
import pojo.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GeneralInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_information)

        val getIntent = intent
        if (getIntent != null){
            val city = getIntent.getStringExtra("city")
            Log.d("city",city!!)
            getCurrentWeather(city)
        }
    }

    private fun getCurrentWeather(city:String?) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getWeather(city, AppId, lang, units)
        call.enqueue(object : Callback<GeneralInformation> {
            override fun onFailure(call: Call<GeneralInformation>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<GeneralInformation>,
                response: Response<GeneralInformation>
            ) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()

                    let {
                        textViewCity.text = weatherResponse?.name
                        textViewCountry.text = weatherResponse?.sys?.country
                        textViewTemp.text ="Температура ${weatherResponse?.main?.temp.toString()} градусов "
                        textViewOnStreet.text = "Ощущается как: ${weatherResponse?.main?.tempMax.toString()} градусов"
                        textViewWind.text = "Скорость ветра ${weatherResponse?.wind?.speed.toString()} м/с"
                        textViewPressure.text ="Давление ${weatherResponse?.main?.pressure.toString()} мрс"
                        textViewHumidity.text ="Влажность ${ weatherResponse?.main?.humidity.toString()} г/м^3"
                    }

                } else{
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        applicationContext,
                        "Error, City name is not correct",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

        })

    }

    companion object {
        val BaseUrl = "http://api.openweathermap.org/"
        val AppId = "599c6324354c3361b2a4f6142a6ec654"
        val lang = "ru"
        val units = "metric"
    }
}