package com.example.barbarian.di

import com.example.barbarian.core.mappers.ModelMapper
import com.example.barbarian.data.local.entities.cat.CatEntity
import com.example.barbarian.data.local.entities.cat.CatEntityMapper
import com.example.barbarian.domain.models.CatModel
import com.example.barbarian.data.network.dtos.cat.CatDto
import com.example.barbarian.data.network.dtos.cat.CatDtoMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @ViewModelScoped
    @Binds
    abstract fun providesCatDtoMapper(catDtoMapper: CatDtoMapper) : ModelMapper<CatDto, CatModel>

    @ViewModelScoped
    @Binds
    abstract fun providesCatEntityMapper(catEntityMapper : CatEntityMapper) : ModelMapper<CatEntity, CatModel>
}