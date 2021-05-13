package com.pabelpm.cleanmarvelcharacters.ui.marvelcharacterdetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabelpm.domain.MarvelCharacter
import com.pabelpm.usescases.GetMarvelCharacters
import kotlinx.coroutines.launch

class MarvelCharactersDetailsViewModel @ViewModelInject constructor(private val getMarvelCharacters: GetMarvelCharacters) : ViewModel() {

}