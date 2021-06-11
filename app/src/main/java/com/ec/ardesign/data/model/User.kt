package com.ec.ardesign.data.model

import androidx.room.PrimaryKey

data class User(
    @PrimaryKey
    val id: String,
    val name: String,
    val lastname: String,
    val mail: String,
    val password: String
)