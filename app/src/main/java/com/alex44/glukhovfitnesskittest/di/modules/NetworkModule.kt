package com.alex44.glukhovfitnesskittest.di.modules

import com.alex44.glukhovfitnesskittest.App
import com.alex44.glukhovfitnesskittest.common.interfaces.INetworkStatus
import com.alex44.glukhovfitnesskittest.common.ui.NetworkStatus
import dagger.Module
import dagger.Provides

@Module(includes = [AppModule::class])
class NetworkModule {

    @Provides
    fun networkStatus(app : App) : INetworkStatus = NetworkStatus(app)

}