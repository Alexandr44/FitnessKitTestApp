package com.alex44.glukhovfitnesskittest.di.modules

import com.alex44.glukhovfitnesskittest.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app : App) {

    @Provides
    fun app() = app

}