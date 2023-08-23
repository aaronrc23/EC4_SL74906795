package com.example.app_avatar

import com.example.app_avatar.Api.consumirApiPersonaje
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retroficpersonajes {


    private const val BASE_URL = "https://last-airbender-api.fly.dev/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(consumirApiPersonaje::class.java)
}