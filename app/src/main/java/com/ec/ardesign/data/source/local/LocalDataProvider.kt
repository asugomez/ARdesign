package com.ec.ardesign.data.source.local

import android.app.Application
import androidx.room.Room
import com.ec.ardesign.data.model.Furniture
import com.ec.ardesign.data.model.StandardFurniture
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
    suspend fun saveOrUpdateUser(users: List<User>){
        return userDao.saveOrUpdate(users)
    }

    suspend fun connexion(pseudo: String, pass:String): User {
        return userDao.connexion(pseudo, pass)
    }

    suspend fun getUsers(): List<User>{
        return userDao.getUsers()
    }

    suspend fun getUserData(idUser: Int): User{
        return userDao.getUserData(idUser)
    }
    suspend fun mkUser(pseudo: String, mail: String, pass: String): User{
        return userDao.mkUser(pseudo, mail, pass)
    }

    //////////////      WALL       //////////////

    suspend fun saveOrUpdateWall(walls: List<Wall>){
        return wallDao.saveOrUpdate(walls)
    }

    suspend fun getWalls(): List<Wall>{
        return wallDao.getWalls()
    }

    suspend fun getWallData(idWall: Int): Wall{
        return wallDao.getWallData(idWall)
    }

    suspend fun getUsersWalls(idUser: Int): List<Wall>{
        return wallDao.getUsersWalls(idUser)
    }

    suspend fun getUsersWall(idUser: Int, idWall: Int): Wall{
        return wallDao.getUsersWall(idUser, idWall)
    }

    suspend fun addUsersWall(idUser: Int, width: String, height: String): Wall{
        return wallDao.addUsersWall(idUser, width, height)
    }

    suspend fun rmUsersWall(idWall: Int, idUser: Int){
        return wallDao.rmUsersWall(idWall, idUser)
    }


    //////////////     FURNITURE       //////////////

    suspend fun saveOrUpdateFurnitures(furnitures: List<Furniture>){
        return furnDao.saveOrUpdate(furnitures)
    }

    suspend fun getFurnitures(): List<Furniture>{
        return furnDao.getFurnitures()
    }

    suspend fun getFurnitureData(idFurn: Int, idUser: Int): Furniture{
        return furnDao.getFurnitureData(idFurn, idUser)
    }

    suspend fun getUsersFurnitures(idUser: Int): List<Furniture>{
        return furnDao.getUsersFurnitures(idUser)
    }

    suspend fun getUsersFurniture(idFurn: Int, idUser: Int): Furniture{
        return furnDao.getUsersFurniture(idFurn, idUser)
    }

    suspend fun addUsersFurniture(idUser: Int, width: String, height: String, length: String): Furniture{
        return furnDao.addUsersFurniture(idUser, width, height, length)
    }

    suspend fun rmUsersFurniture(idFurn: Int, idUser: Int){
        return furnDao.rmUsersFurniture(idFurn, idUser)
    }

    //////////////      STAND FURNITURE        //////////////

    suspend fun saveOrUpdateStandFurn(standFurns: List<StandardFurniture>){
        return standFurnDao.saveOrUpdate(standFurns)
    }

    suspend fun getStandFurnitures(): List<StandardFurniture>{
        return standFurnDao.getStandFurnitures()
    }

    suspend fun getStandFurnitureData(id: Int): StandardFurniture{
        return standFurnDao.getStandFurnitureData(id)
    }

    suspend fun addStandFurniture(width: String, height: String, length: String, url:String): StandardFurniture{
        return standFurnDao.addStandFurniture(width, height, length, url)
    }


}