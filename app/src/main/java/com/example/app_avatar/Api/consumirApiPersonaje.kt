package com.example.app_avatar.Api

import com.example.app_avatar.clases.Personajes
import retrofit2.Call
import retrofit2.http.GET

interface consumirApiPersonaje {
    @GET("characters")
    fun getTraerCategoria(): Call<List<Personajes>>

}