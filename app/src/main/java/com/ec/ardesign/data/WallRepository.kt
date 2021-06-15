package com.ec.ardesign.data

import android.app.Application
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
}