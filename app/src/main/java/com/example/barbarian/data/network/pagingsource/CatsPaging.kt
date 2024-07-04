package com.example.barbarian.data.network.pagingsource

import android.util.Log
import com.example.barbarian.data.network.CatsApi
import com.example.barbarian.data.network.dtos.cat.CatDto
import java.io.IOException

class CatsPaging(private val catsApi: CatsApi) : BasePagingSource<CatDto>() {
    override suspend fun dataList(pageSize: Int, page: Int): List<CatDto> {
        return try {
            val response = catsApi.getCatImages(
                size = pageSize,
                page = page
            )
//            delay(1000L)
            response
        }catch (e : IOException){
            Log.d("HTTPException", e.localizedMessage?:" IOException")
            emptyList()
        }
    }
}
