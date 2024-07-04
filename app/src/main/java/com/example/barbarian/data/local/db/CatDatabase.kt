package com.example.barbarian.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barbarian.data.local.dao.CatDao
import com.example.barbarian.data.local.dao.DataKeysDao
import com.example.barbarian.data.local.entities.cat.CatEntity
import com.example.barbarian.data.local.entities.RemoteKeyEntity

@Database(version = 1, entities = [CatEntity::class, RemoteKeyEntity::class])
abstract class CatDatabase : RoomDatabase() {
    abstract fun getCatDao(): CatDao
    abstract fun getKeysDao(): DataKeysDao
}