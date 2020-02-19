package com.alex44.glukhovfitnesskittest.di.modules

import dagger.Module

@Module(includes = [ApiModule::class, NetworkModule::class])
class RepoModule {

}