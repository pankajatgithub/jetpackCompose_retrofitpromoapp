package com.example.jetpackcompose_retrofitpromoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose_retrofitpromoapp.repository.CharacterRepo
import com.example.jetpackcompose_retrofitpromoapp.retrofit.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(val characterRepo: CharacterRepo) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
     get() = _state
init {
    viewModelScope.launch {
        val characters = characterRepo.getCharacters()
        _state.value = characters
    }
}

}