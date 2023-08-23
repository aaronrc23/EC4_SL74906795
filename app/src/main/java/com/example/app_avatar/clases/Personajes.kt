package com.example.app_avatar.clases

data class Personajes(
    val _id: String,
    val affiliation: String,
    val allies: List<String>,
    val enemies: List<String>,
    val name: String,
    val photoUrl: String
)