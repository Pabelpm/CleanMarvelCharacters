package com.pabelpm.cleanmarvelcharacters.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabelpm.domain.MarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacters
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val getMarvelCharacters: GetMarvelCharacters,private val getMarvelCharacter: GetMarvelCharacter) : ViewModel() {

    private val _marvelCharactersLiveData = MutableLiveData<List<MarvelCharacter>>()
    val marvelCharactersLiveData: LiveData<List<MarvelCharacter>> get() = _marvelCharactersLiveData

    private val _navigateToMarvelCharacterDetails = MutableLiveData<String>()
    val navigateToMarvelCharacterDetails: LiveData<String> get() = _navigateToMarvelCharacterDetails

    fun getMarvelCharacters() {
        viewModelScope.launch {
            _marvelCharactersLiveData.value =  getMarvelCharacters.invoke()
        }
    }

    fun getMarvelCharacter(id:String) {
        viewModelScope.launch {
            val marvelCharacter = getMarvelCharacter.invoke(id)
            _navigateToMarvelCharacterDetails.value = marvelCharacter.id
        }
    }

    fun onMarvelCharacterClicked(marvelCharacter: MarvelCharacter) {
        _navigateToMarvelCharacterDetails.value = marvelCharacter.id
    }
}