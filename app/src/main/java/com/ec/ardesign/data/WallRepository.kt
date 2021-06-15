package com.ec.ardesign.data

import android.app.Application
import com.ec.ardesign.data.model.User
import com.ec.ardesign.data.model.Wall
import com.ec.ardesign.data.source.local.LocalDataProvider
import com.ec.ardesign.data.source.remote.RemoteDataProvider

class WallRepository(
    private val localDataProvider: LocalDataProvider,
    private val remoteDataProvider: RemoteDataProvider
) {
    companion object {
        fun newInstance(application: Application): WallRepository {
            return WallRepository(
                localDataProvider = LocalDataProvider(application),
                remoteDataProvider = RemoteDataProvider()
            )
        }
    }

    suspend fun getWalls(hash: String): List<Wall>{
        return try{
            remoteDataProvider.getWalls(hash).also {
                localDataProvider.saveOrUpdateWall(it)
            }
        } catch (e:Exception){
            localDataProvider.getWalls()
        }
    }

}