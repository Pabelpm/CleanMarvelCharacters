package com.pabelpm.cleanmarvelcharacters.ui.marvelcharacterdetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabelpm.domain.MarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacters
import kotlinx.coroutines.launch

class MarvelCharacterDetailsViewModel @ViewModelInject constructor(private val getMarvelCharacter: GetMarvelCharacter) : ViewModel() {
    private val _marvelCharacterLiveData = MutableLiveData<MarvelCharacter>()
    val marvelCharacterLiveData: LiveData<MarvelCharacter> get() = _marvelCharacterLiveData

    fun getMarvelCharacter(id:String) {
        viewModelScope.launch {
            _marvelCharacterLiveData.value =  getMarvelCharacter.invoke(id)
        }
    }
}