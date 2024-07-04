package com.example.barbarian.data.repositories

import com.example.barbarian.data.local.entities.RemoteKeyEntity
import com.example.barbarian.domain.models.DataModel

interface KeysRepo {
    suspend fun insertKeys(dataList: List<DataModel>, prevKey: Int?, nextKey: Int?)
    suspend fun getKeysByDataId(id: String): RemoteKeyEntity?
    suspend fun insertAll(remoteKey: List<RemoteKeyEntity>)
    suspend fun deleteAll()
}