package com.ec.ardesign.data.model

import com.google.gson.annotations.SerializedName


data class ObjectFurnitureResponse(
    @SerializedName("objects")
    val objectFurnitureResponse: List<ObjectFurnitureResponse>

)