package com.example.barbarian.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.barbarian.core.PAGE_SIZE
import com.example.barbarian.core.mappers.ModelMapper
import com.example.barbarian.data.local.dao.CatDao
import com.example.barbarian.data.local.entities.cat.CatEntity
import com.example.barbarian.data.local.preferences.TinyDB
import com.example.barbarian.data.network.CatsApi
import com.example.barbarian.data.network.dtos.cat.CatDto
import com.example.barbarian.data.network.pagingmediator.CatsRemoteMediator
import com.example.barbarian.data.network.pagingsource.CatsPaging
import com.example.barbarian.domain.models.CatModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CatsRepoImpl @Inject constructor(
    private val catsApi: CatsApi,
    private val catDao: CatDao,
    private val tinyDB: TinyDB,
    private val keysRepo: KeysRepo,
    private val catModelEntityMapper: ModelMapper<CatEntity, CatModel>,
    private val catModelModelMapper: ModelMapper<CatDto, CatModel>,
    private val catMediator : CatsRemoteMediator
) : CatsRepo {
    override fun getRemoteCats(): Flow<PagingData<CatModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = PAGE_SIZE + (PAGE_SIZE * 2),
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CatsPaging(catsApi) }
        ).flow.map {
            it.map { catDto ->
                catModelModelMapper.mapToModel(catDto)
            }
        }
    }

    override fun getLocalCats(): Flow<PagingData<CatModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = PAGE_SIZE + (PAGE_SIZE * 2),
                enablePlaceholders = false
            ),
            pagingSourceFactory = { catDao.getAll() }
        ).flow.map {
            it.map { catEntity ->
                catModelEntityMapper.mapToModel(catEntity)
            }
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getCatsFromMediator(): Flow<PagingData<CatModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = PAGE_SIZE + (PAGE_SIZE * 2),
                enablePlaceholders = false
            ),
            remoteMediator = catMediator,
            pagingSourceFactory = { catDao.getAll() }
        ).flow.map {
            it.map { catEntity ->
                catModelEntityMapper.mapToModel(catEntity)
            }
        }
    }

    override suspend fun insertCats(cats: List<CatModel>) {
        catDao.insertAll(cats.map {
            catModelEntityMapper.mapFromDomain(it)
        })
    }

    override suspend fun deleteAll() = catDao.deleteAll()

    override suspend fun getPagedRemoteCats(pageSize: Int, page: Int) =
        catsApi.getCatImages(page = page, size = pageSize)
            .map { catModelModelMapper.mapToModel(it) }

}