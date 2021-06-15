package com.ec.ardesign.data.source.local

import android.app.Application
import androidx.room.Room
import com.ec.ardesign.data.model.User
import com.ec.ardesign.data.model.Wall
import com.ec.ardesign.data.source.local.database.ObjectFurnitureDatabase

class LocalDataProvider(
    application: Application
) {

    private val roomDatabase =
        Room.databaseBuilder(application, ObjectFurnitureDatabase::class.java, "room-database").build()


    private val userDao = roomDatabase.userDao()
    private val wallDao = roomDatabase.wallDao()
    private val furnDao = roomDatabase.furnitureDao()
    private val standFurnDao = roomDatabase.standFurnDao()

    //////////////      USER        //////////////
    suspend fun connexion(pseudo: String, pass:String): User {
        return userDao.connexion(pseudo, pass)
    }

    suspend fun saveOrUpdateUser(users: List<User>){
        return userDao.saveOrUpdate(users)
    }

    //////////////      WALL       //////////////

    //////////////     FURNITURE       //////////////

    //////////////      STAND FURNITURE        //////////////

}