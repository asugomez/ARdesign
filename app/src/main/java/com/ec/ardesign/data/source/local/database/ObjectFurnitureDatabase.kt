package com.ec.ardesign.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ec.ardesign.data.model.Furniture
import com.ec.ardesign.data.model.StandardFurniture
import com.ec.ardesign.data.model.User
import com.ec.ardesign.data.model.Wall

@Database(
    entities = [
        User::class,
        Wall::class,
        Furniture::class,
        StandardFurniture::class
    ],
    version = 1
)

abstract class ObjectFurnitureDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun wallDao(): WallDao
    abstract fun furnitureDao(): FurnitureDao
    abstract fun standFurnDao(): StandFurnitureDao
}