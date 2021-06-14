package com.ec.ardesign.data.source.remote

import com.ec.ardesign.data.model.Wall
import com.ec.ardesign.data.model.User
import com.ec.ardesign.data.source.remote.api.ObjectFurnitureAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataProvider {

    private val BASE_URL = ""

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val service = retrofit.create(ObjectFurnitureAPI::class.java)

    suspend fun getUsers(hash: String): List<User> = service.getUsers(hash).users.toUsers()

    private fun List<User>.toUsers() = this.map { userResponse ->
        User(
            id = userResponse.id,
            name = userResponse.name,
            lastname = userResponse.lastname,
            mail = userResponse.mail,
            password = userResponse.password
        )
    }

    suspend fun getObjectsFurniture(): List<Wall>
        = service.getObjectsFurniture().objects.toObjectsFurniture()

    suspend fun getObjectsFromUser(id: String, hash:String): List<Wall>
            = service.getObjectsFurnitureFromUser(id,hash).objects.toObjectsFurniture()

    private fun List<Wall>.toObjectsFurniture() = this.map { objectFurniture ->
        Wall(
            id = objectFurniture.id,
            id_user = objectFurniture.id_user,
            type = objectFurniture.type,
            width = objectFurniture.width,
            height = objectFurniture.height
        )
    }

}