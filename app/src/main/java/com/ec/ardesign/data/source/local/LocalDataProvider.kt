package com.ec.ardesign.data.source.local

import android.app.Application
import androidx.room.Room
import com.ec.ardesign.data.model.ObjectFurniture
import com.ec.ardesign.data.source.local.database.ObjectFurnitureDatabase

class LocalDataProvider(
    application: Application
) {

    private val roomDatabase =
        Room.databaseBuilder(application, ObjectFurnitureDatabase::class.java, "room-database").build()


    private val objectDao = roomDatabase.objectDao()


    suspend fun getObjectsFurniture() = objectDao.getObjectsFurnitures()

    suspend fun saveOrUpdate(objects: List<ObjectFurniture>) = objectDao.saveOrUpdate(objects)
}