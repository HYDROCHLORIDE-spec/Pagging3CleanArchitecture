package com.example.barbarian.data.local.entities.cat

import com.example.barbarian.core.mappers.ModelMapper
import com.example.barbarian.domain.models.CatModel
import javax.inject.Inject

class CatEntityMapper @Inject constructor() : ModelMapper<CatEntity, CatModel> {

    override fun mapToModel(obj: CatEntity) =
        CatModel(
            id = obj.id,
            url = obj.url
        )

    override fun mapFromDomain(domain: CatModel) =
        CatEntity(
            id = domain.id,
            url = domain.url
        )

}
