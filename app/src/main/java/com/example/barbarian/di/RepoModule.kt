package com.example.barbarian.di

import com.example.barbarian.data.repositories.CatsRepo
import com.example.barbarian.data.repositories.CatsRepoImpl
import com.example.barbarian.data.repositories.KeysRepo
import com.example.barbarian.data.repositories.KeysRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @ViewModelScoped
    @Binds
    abstract fun bindCatsRepository(catsRepo : CatsRepoImpl) : CatsRepo

    @ViewModelScoped
    @Binds
    abstract fun bindKeysRepoModule(keysRepo: KeysRepoImpl) : KeysRepo
}