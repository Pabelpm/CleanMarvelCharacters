package com.pabelpm.cleanmarvelcharacters.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabelpm.usescases.GetMarvelCharacters
import kotlinx.coroutines.launch

class MainViewModel(private val getMarvelCharacters: GetMarvelCharacters): ViewModel() {

    fun getMarvelCharacters(){
        viewModelScope.launch {
            getMarvelCharacters.invoke()
        }
    }
}