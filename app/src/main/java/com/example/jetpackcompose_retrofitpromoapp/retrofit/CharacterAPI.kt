package com.example.jetpackcompose_retrofitpromoapp.retrofit

import retrofit2.http.GET

interface CharacterAPI {

@GET("api/characters") //end point
suspend fun getCharacters():List<Character>
}