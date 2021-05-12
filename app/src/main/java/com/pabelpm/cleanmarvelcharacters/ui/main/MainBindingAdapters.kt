package com.pabelpm.cleanmarvelcharacters.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pabelpm.cleanmarvelcharacters.ui.adapters.MarvelCharactersAdapter
import com.pabelpm.domain.MarvelCharacter

@BindingAdapter("items")
fun RecyclerView.setItems(marvelCharacters: List<MarvelCharacter>?) {
    (adapter as? MarvelCharactersAdapter)?.let {
        it.marvelCharacters = marvelCharacters ?: emptyList()
    }
}