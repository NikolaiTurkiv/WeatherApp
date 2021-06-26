package com.example.weatherappsimple

import pojo.GeneralInformation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface ApiService {
    @GET("data/2.5/weather?")
    fun getWeather(@Query("q") city : String?,
                   @Query("appid") APPID : String,
                   @Query("lang") lang:String,
                   @Query("units") units:String):Call<GeneralInformation>
}