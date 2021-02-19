package com.maeldebon.contest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton
{
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}