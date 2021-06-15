package com.ec.ardesign.data

import android.app.Application
import com.ec.ardesign.data.source.local.LocalDataProvider
import com.ec.ardesign.data.source.remote.RemoteDataProvider

class StandardFurnitureRepository(
    private val localDataProvider: LocalDataProvider,
    private val remoteDataProvider: RemoteDataProvider
) {
    companion object {
        fun newInstance(application: Application): StandardFurnitureRepository {
            return StandardFurnitureRepository(
                localDataProvider = LocalDataProvider(application),
                remoteDataProvider = RemoteDataProvider()
            )
        }
    }
}