package com.ec.ardesign.data

import android.app.Application
import com.ec.ardesign.data.source.local.LocalDataProvider
import com.ec.ardesign.data.source.remote.RemoteDataProvider

class FurnitureRepository(
    private val localDataProvider: LocalDataProvider,
    private val remoteDataProvider: RemoteDataProvider
) {
    companion object {
        fun newInstance(application: Application): FurnitureRepository {
            return FurnitureRepository(
                localDataProvider = LocalDataProvider(application),
                remoteDataProvider = RemoteDataProvider()
            )
        }
    }
}


    /*
    suspend fun getObjectsFurniture(): List<Wall>{
        return try{
            remoteDataProvider.getObjectsFurniture().also {
                localDataProvider.saveOrUpdate(it)
            }
        } catch (e: Exception){
            localDataProvider.getObjectsFurniture()
        }
    }
     */
