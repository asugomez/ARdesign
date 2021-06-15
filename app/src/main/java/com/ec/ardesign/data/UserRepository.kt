package com.ec.ardesign.data

import android.app.Application
import com.ec.ardesign.data.model.User
import com.ec.ardesign.data.source.local.LocalDataProvider
import com.ec.ardesign.data.source.remote.RemoteDataProvider

class UserRepository(
    private val localDataProvider: LocalDataProvider,
    private val remoteDataProvider: RemoteDataProvider
) {
    companion object {
        fun newInstance(application: Application): UserRepository {
            return UserRepository(
                localDataProvider = LocalDataProvider(application),
                remoteDataProvider = RemoteDataProvider()
            )
        }
    }

    suspend fun connexion(pseudo: String, pass:String): User {
        return try{
            remoteDataProvider.connexion(pseudo,pass)
        } catch (e: Exception){
            localDataProvider.connexion(pseudo, pass)
        }
    }
}