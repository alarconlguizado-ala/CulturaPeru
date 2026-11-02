package com.example.culturaperu.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .baseUrl("https://albertobd.alwaysdata.net/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    val registrosService: RegistrosService by lazy {
        retrofit.create(RegistrosService::class.java)
    }
}