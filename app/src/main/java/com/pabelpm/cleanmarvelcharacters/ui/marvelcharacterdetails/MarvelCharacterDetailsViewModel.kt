package com.pabelpm.cleanmarvelcharacters.ui.marvelcharacterdetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pabelpm.domain.MarvelCharacter

class MarvelCharacterDetailsViewModel @ViewModelInject constructor() : ViewModel() {
    private val _marvelCharacterLiveData = MutableLiveData<MarvelCharacter>()
    val marvelCharacterLiveData: LiveData<MarvelCharacter> get() = _marvelCharacterLiveData
}