package com.pabelpm.cleanmarvelcharacters.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalPaginationOffset(
    @PrimaryKey val id: Int= 0,
    val offset:Int
)