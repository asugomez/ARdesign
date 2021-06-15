package com.ec.ardesign.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wall(
    @PrimaryKey val id: Int,
    val idUser: String,
    val width: String,
    val height: String
)