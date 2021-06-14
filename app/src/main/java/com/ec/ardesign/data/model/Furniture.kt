package com.ec.ardesign.data.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Furniture (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "idUser") val idUser: String,
    @ColumnInfo(name = "width")  val width: String,
    @ColumnInfo(name = "height") val height: String,
    @ColumnInfo(name = "length") val length: String
    )