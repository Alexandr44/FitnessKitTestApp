package com.alex44.glukhovfitnesskittest.di.modules

import com.alex44.glukhovfitnesskittest.common.interfaces.INetworkStatus
import com.alex44.glukhovfitnesskittest.model.api.IDataSource
import com.alex44.glukhovfitnesskittest.model.repo.DataRepo
import com.alex44.glukhovfitnesskittest.model.repo.IDataRepo
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class, NetworkModule::class])
class RepoModule {

    @Provides
    fun repo(dataSource : IDataSource, networkStatus : INetworkStatus) : IDataRepo = DataRepo(dataSource, networkStatus)

}