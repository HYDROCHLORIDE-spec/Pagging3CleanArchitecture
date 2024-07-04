package com.example.barbarian.data.network.dtos.cat

import com.example.barbarian.domain.models.DataModel
import com.google.gson.annotations.SerializedName

data class CatDto(
    @SerializedName("id")
    override val id: String,
    @SerializedName("url")
    val url: String
) : DataModel()