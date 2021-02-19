package com.maeldebon.contest

import retrofit2.Call
import retrofit2.http.GET

interface WSInterface
{
    @GET("/rest/v2")
    fun getCountries(): Call<RetourWSGet>
}