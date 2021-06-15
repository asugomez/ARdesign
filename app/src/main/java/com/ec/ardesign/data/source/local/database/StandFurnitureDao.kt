package com.ec.ardesign.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ec.ardesign.data.model.Furniture
import com.ec.ardesign.data.model.StandardFurniture

@Dao
interface StandFurnitureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrUpdate(users: List<StandardFurniture>)

}