package com.ec.ardesign.data.source.remote.api

import com.ec.ardesign.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ObjectFurnitureAPI {

    @GET("users")
    suspend fun getUsers(@Header("hash")hash: String): UserResponse

}