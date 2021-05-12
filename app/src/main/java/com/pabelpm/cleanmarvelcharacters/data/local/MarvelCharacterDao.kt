package com.pabelpm.cleanmarvelcharacters.data.local

import androidx.room.*

@Dao
interface MarvelCharacterDao {
    @Query("SELECT * FROM LocalMarvelCharacter")
    fun getAll(): List<LocalMarvelCharacter>

    @Query("SELECT * FROM LocalMarvelCharacter WHERE id = :id")
    fun findById(id: String): LocalMarvelCharacter

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMarvelCharacter(localMarvelCharacter: LocalMarvelCharacter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMarvelCharacters(localMarvelCharacters: List<LocalMarvelCharacter>)
}