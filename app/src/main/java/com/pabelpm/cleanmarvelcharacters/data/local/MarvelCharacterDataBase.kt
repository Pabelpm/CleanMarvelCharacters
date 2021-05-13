package com.pabelpm.cleanmarvelcharacters.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalMarvelCharacter::class, LocalPaginationOffset::class],
    version = 3,
    exportSchema = false
)
abstract class MarvelCharacterDataBase : RoomDatabase() {
    abstract fun marvelCharacterDao(): MarvelCharacterDao
    abstract fun paginationOffsetDao(): PaginationOffsetDao
}
