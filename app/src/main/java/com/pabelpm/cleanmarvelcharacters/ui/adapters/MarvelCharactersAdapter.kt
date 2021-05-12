package com.pabelpm.cleanmarvelcharacters.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pabelpm.cleanmarvelcharacters.R
import com.pabelpm.cleanmarvelcharacters.databinding.RowMarvelCharacterBinding
import com.pabelpm.domain.MarvelCharacter
import kotlin.properties.Delegates

class MarvelCharactersAdapter(private val listener: (MarvelCharacter) -> Unit) :
    RecyclerView.Adapter<MarvelCharactersAdapter.ViewHolder>() {

    var marvelCharacters: List<MarvelCharacter> by basicDiffUtil(
    emptyList(),
    areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.row_marvel_character, parent,false))
    }

    override fun getItemCount(): Int = marvelCharacters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val marvelCharacter = marvelCharacters[position]
        holder.dataBinding.marvelCharacter = marvelCharacter
        holder.itemView.setOnClickListener { listener(marvelCharacter) }
    }

    class ViewHolder(val dataBinding: RowMarvelCharacterBinding) : RecyclerView.ViewHolder(dataBinding.root)

    fun <VH : RecyclerView.ViewHolder, T> RecyclerView.Adapter<VH>.basicDiffUtil(
        initialValue: List<T>,
        areItemsTheSame: (T, T) -> Boolean = { old, new -> old == new },
        areContentsTheSame: (T, T) -> Boolean = { old, new -> old == new }
    ) =
        Delegates.observable(initialValue) { _, old, new ->
            DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    areItemsTheSame(old[oldItemPosition], new[newItemPosition])

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    areContentsTheSame(old[oldItemPosition], new[newItemPosition])

                override fun getOldListSize(): Int = old.size

                override fun getNewListSize(): Int = new.size
            }).dispatchUpdatesTo(this@basicDiffUtil)
        }

}
