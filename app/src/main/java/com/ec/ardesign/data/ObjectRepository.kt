package com.ec.ardesign.data

import android.app.Application
import com.ec.ardesign.data.model.ObjectFurniture
import com.ec.ardesign.data.source.local.LocalDataProvider
import com.ec.ardesign.data.source.remote.RemoteDataProvider

class ObjectRepository(
    private val localDataProvider: LocalDataProvider,
    private val remoteDataProvider: RemoteDataProvider
){
    suspend fun getObjectsFurniture(): List<ObjectFurniture>{
        return try{
            remoteDataProvider.getObjectsFurniture().also {
                localDataProvider.saveOrUpdate(it)
            }
        } catch (e: Exception){
            localDataProvider.getObjectsFurniture()
        }
    }

    companion object {
        fun newInstance(application: Application): ObjectRepository {
            return ObjectRepository(
                localDataProvider = LocalDataProvider(application),
                remoteDataProvider = RemoteDataProvider()
            )
        }
    }
}