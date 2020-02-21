package com.alex44.glukhovfitnesskittest.di.modules

import com.alex44.glukhovfitnesskittest.model.cache.IDataCache
import com.alex44.glukhovfitnesskittest.model.cache.RoomDataCache
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CacheModule {

    @Named("Room")
    @Provides
    fun cache() : IDataCache = RoomDataCache()

}