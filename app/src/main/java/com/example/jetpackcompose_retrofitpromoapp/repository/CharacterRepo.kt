package com.example.jetpackcompose_retrofitpromoapp.repository

import com.example.jetpackcompose_retrofitpromoapp.retrofit.Character
import com.example.jetpackcompose_retrofitpromoapp.retrofit.CharacterAPI

class CharacterRepo(private val characterAPI: CharacterAPI) {

    suspend fun getCharacters(): List<Character>{

        return characterAPI.getCharacters()
    }
}