package com.pabelpm.cleanmarvelcharacters.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabelpm.usescases.GetMarvelCharacters
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val getMarvelCharacters: GetMarvelCharacters): ViewModel() {

    fun getMarvelCharacters(){
        viewModelScope.launch {
            getMarvelCharacters.invoke()
        }
    }
}