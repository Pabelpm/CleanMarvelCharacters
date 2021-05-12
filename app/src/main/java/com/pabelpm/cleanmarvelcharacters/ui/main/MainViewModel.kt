package com.pabelpm.cleanmarvelcharacters.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabelpm.domain.MarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacters
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val getMarvelCharacters: GetMarvelCharacters) : ViewModel() {

    private val _marvelCharactersLiveData = MutableLiveData<List<MarvelCharacter>>()
    val marvelCharactersLiveData: LiveData<List<MarvelCharacter>> get() = _marvelCharactersLiveData

    fun getMarvelCharacters() {
        viewModelScope.launch {
            _marvelCharactersLiveData.value =  getMarvelCharacters.invoke()
        }
    }
}