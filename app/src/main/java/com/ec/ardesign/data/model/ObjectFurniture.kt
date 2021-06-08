package com.ec.ardesign.data.model

import androidx.room.PrimaryKey

data class ObjectFurniture(
    @PrimaryKey
    val id: String,
    val id_user: String,
    val type: String,
    val width: String,
    val height: String
)