package com.example.barbarian.data.repositories

import androidx.paging.PagingData
import com.example.barbarian.domain.models.CatModel
import kotlinx.coroutines.flow.Flow

interface CatsRepo {
    fun getRemoteCats(): Flow<PagingData<CatModel>>
    fun getLocalCats(): Flow<PagingData<CatModel>>
    fun getCatsFromMediator(): Flow<PagingData<CatModel>>
    suspend fun insertCats(cats: List<CatModel>)
    suspend fun deleteAll()
    suspend fun getPagedRemoteCats(pageSize: Int, page: Int): List<CatModel>
}
