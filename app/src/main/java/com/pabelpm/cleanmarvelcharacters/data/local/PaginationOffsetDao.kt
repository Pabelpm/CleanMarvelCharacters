package com.pabelpm.cleanmarvelcharacters.data.local

import androidx.room.*

@Dao
interface PaginationOffsetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateOffset(localPaginationOffset: LocalPaginationOffset)

    @Query("SELECT * FROM LocalPaginationOffset")
    fun getOffset(): LocalPaginationOffset
}