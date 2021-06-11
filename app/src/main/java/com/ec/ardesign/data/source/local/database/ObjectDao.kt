package com.ec.ardesign.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ec.ardesign.data.model.ObjectFurniture

@Dao
interface ObjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrUpdate(objects: List<ObjectFurniture>)

    @Query("SELECT * FROM OBJECTFURNITURE")
    suspend fun getObjectsFurnitures(): List<ObjectFurniture>
}