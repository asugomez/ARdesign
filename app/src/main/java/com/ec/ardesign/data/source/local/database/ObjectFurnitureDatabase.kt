package com.ec.ardesign.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ec.ardesign.data.model.Wall

@Database(
    entities = [
        Wall::class
    ],
    version = 1
)

abstract class ObjectFurnitureDatabase: RoomDatabase() {
    abstract fun objectDao(): ObjectDao
}