package com.ec.ardesign.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ec.ardesign.data.model.User
import com.ec.ardesign.data.model.Wall


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrUpdate(objects: List<User>)

    @Query("SELECT * " +
            "FROM user")
    suspend fun getUsers(): List<User>
}