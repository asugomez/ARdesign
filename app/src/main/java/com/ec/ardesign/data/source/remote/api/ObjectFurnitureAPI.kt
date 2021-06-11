package com.ec.ardesign.data.source.remote.api

import com.ec.ardesign.data.model.ObjectFurnitureResponse
import com.ec.ardesign.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ObjectFurnitureAPI {

    @GET("users")
    suspend fun getUsers(@Header("hash")hash: String): UserResponse

    @GET("objectsfurniture")
    suspend fun getObjectsFurniture(): ObjectFurnitureResponse

    @GET("users/{id}/objectsfurniture")
    suspend fun getObjectsFurnitureFromUser(@Path("id") id: String,
                                            @Header("hash") hash: String): ObjectFurnitureResponse


}