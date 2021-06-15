package com.ec.ardesign.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pseudo") val pseudo: String,
    @ColumnInfo(name = "mail")  val mail: String,
    @ColumnInfo(name = "pass") val pass: String,
    @ColumnInfo(name = "hash") val hash: String
)