package com.pabelpm.cleanmarvelcharacters.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalMarvelCharacter(
    @PrimaryKey val id: String,
    val url: String,
    val name: String,
    val description: String
)