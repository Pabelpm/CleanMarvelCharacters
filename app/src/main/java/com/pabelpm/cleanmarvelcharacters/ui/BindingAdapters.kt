package com.pabelpm.cleanmarvelcharacters.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pabelpm.cleanmarvelcharacters.ui.adapters.MarvelCharactersAdapter
import com.pabelpm.domain.MarvelCharacter

@BindingAdapter("items")
fun RecyclerView.setItems(marvelCharacters: List<MarvelCharacter>?) {
    (adapter as? MarvelCharactersAdapter)?.let {
        it.marvelCharacters = marvelCharacters ?: emptyList()
    }
}

@BindingAdapter("url")
fun ImageView.bindUrl(url: String?) {
    if (url != null) Glide.with(context).load(url).centerCrop().into(this)
}