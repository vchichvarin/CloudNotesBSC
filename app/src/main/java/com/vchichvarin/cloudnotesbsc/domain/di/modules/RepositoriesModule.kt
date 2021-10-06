package com.vchichvarin.cloudnotesbsc.domain.di.modules

import com.vchichvarin.cloudnotesbsc.data.impl.SaveRepositoryImpl
import com.vchichvarin.cloudnotesbsc.data.interfaces.SaveRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun saveRepository(saveRepositoryImpl: SaveRepositoryImpl) : SaveRepository

}