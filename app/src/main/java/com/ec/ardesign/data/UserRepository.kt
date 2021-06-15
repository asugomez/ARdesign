package com.ec.ardesign.data

import android.app.Application
import android.util.Log
import android.widget.Toast
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
            Log.d("PMR", "here in userRepository")
            remoteDataProvider.connexion(pseudo,pass).also {
                localDataProvider.saveOrUpdateUser(listOf(it)) // dont know if it works
            }
        } catch (e: Exception){
            localDataProvider.connexion(pseudo, pass)
        }
    }
}