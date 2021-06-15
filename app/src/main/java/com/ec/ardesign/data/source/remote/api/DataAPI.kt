package com.ec.ardesign.data.source.remote.api

import com.ec.ardesign.data.model.*
import retrofit2.http.*

interface DataAPI {

    //////////////      USER        //////////////
    @POST("authenticate")
    suspend fun connexion(@Query("user") user: String,
                          @Query("password") password: String) : User

}