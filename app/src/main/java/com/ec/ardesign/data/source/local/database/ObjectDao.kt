package com.ec.ardesign.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ec.ardesign.data.model.Wall

@Dao
interface ObjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrUpdate(objects: List<Wall>)

    @Query("SELECT * " +
            "FROM OBJECTFURNITURE")
    suspend fun getObjectsFurnitures(): List<Wall>
}