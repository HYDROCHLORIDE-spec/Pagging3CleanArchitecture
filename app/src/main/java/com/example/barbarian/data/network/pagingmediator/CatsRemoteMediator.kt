package com.example.barbarian.data.network.pagingmediator

import com.example.barbarian.data.local.entities.cat.CatEntity
import com.example.barbarian.data.local.preferences.TinyDB
import com.example.barbarian.data.repositories.CatsRepo
import com.example.barbarian.data.repositories.KeysRepo
import javax.inject.Inject

class CatsRemoteMediator @Inject constructor(
    tinyDb: TinyDB,
    catsRepo: CatsRepo,
    keysRepo: KeysRepo,
) : BaseRemoteMediator<CatEntity>(
    tinyDb,
    catsRepo,
    keysRepo
)