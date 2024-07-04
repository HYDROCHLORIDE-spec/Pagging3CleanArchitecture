package com.example.barbarian.domain.models

data class CatModel(
    override val id: String,
    val url: String
) : DataModel()
