package com.example.barbarian.data.repositories

import com.example.barbarian.data.local.dao.DataKeysDao
import com.example.barbarian.data.local.entities.RemoteKeyEntity
import com.example.barbarian.domain.models.DataModel
import javax.inject.Inject

class KeysRepoImpl @Inject constructor(
    private val keysDao: DataKeysDao,
) : KeysRepo {
    override suspend fun insertKeys(
        dataList: List<DataModel>,
        prevKey: Int?,
        nextKey: Int?
    ) {
        val keys = dataList.map {
            RemoteKeyEntity(it.id, prevKey = prevKey, nextKey = nextKey)
        }
        insertAll(keys)
    }

    override suspend fun getKeysByDataId(id: String) = keysDao.getKeysByDataId(id)
    override suspend fun insertAll(remoteKey: List<RemoteKeyEntity>) = keysDao.insertAll(remoteKey)
    override suspend fun deleteAll() = keysDao.deleteAll()
}