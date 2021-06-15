package com.ec.ardesign.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ec.ardesign.data.model.Furniture
import com.ec.ardesign.data.model.StandardFurniture

@Dao
interface StandFurnitureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrUpdate(standFurns: List<StandardFurniture>)

    @Query("SELECT *" +
            " FROM standardFurniture")
    suspend fun getStandFurnitures(): List<StandardFurniture>

    @Query("SELECT *" +
            " FROM standardFurniture" +
            " WHERE id=:id")
    suspend fun getStandFurnitureData(id: Int): StandardFurniture

    @Query("INSERT INTO standardFurniture(width, height, length, url) " +
            "VALUES(:width, :height, :length, :url)")
    suspend fun addStandFurniture(width: String, height: String, length: String, url:String)



}