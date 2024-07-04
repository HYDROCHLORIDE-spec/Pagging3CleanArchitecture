package com.example.barbarian.data.network.dtos.cat

import com.example.barbarian.core.mappers.ModelMapper
import com.example.barbarian.domain.models.CatModel
import javax.inject.Inject

class CatDtoMapper @Inject constructor(): ModelMapper<CatDto, CatModel> {

    override fun mapToModel(obj: CatDto) =
        CatModel(
            id = obj.id,
            url = obj.url
        )

    override fun mapFromDomain(domain: CatModel) =
        CatDto(
            id = domain.id,
            url = domain.url
        )

}