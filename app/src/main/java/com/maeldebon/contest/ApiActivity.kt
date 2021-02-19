package com.maeldebon.contest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        val service = RetrofitSingleton.retrofit.create(WSInterface::class.java)
        val call = service.getCountries()
        call.enqueue(object : Callback<RetourWSGet>
        {
            override fun onResponse(call: Call<RetourWSGet>, response: Response<RetourWSGet>) {
                if (response.isSuccessful)
                {
                    val retourWSGet = response.body()
                    Log.d("tag", "$retourWSGet")
                }
            }

            override fun onFailure(call: Call<RetourWSGet>, t: Throwable) {
                Log.e("tag", "${t.message}")
            }

        })
    }
}