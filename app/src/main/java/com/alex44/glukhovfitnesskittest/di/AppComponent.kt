package com.alex44.glukhovfitnesskittest.di

import com.alex44.glukhovfitnesskittest.di.modules.AppModule
import com.alex44.glukhovfitnesskittest.di.modules.CiceroneModule
import com.alex44.glukhovfitnesskittest.di.modules.ImageModule
import com.alex44.glukhovfitnesskittest.di.modules.RepoModule
import com.alex44.glukhovfitnesskittest.presenters.MainPresenter
import com.alex44.glukhovfitnesskittest.ui.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ImageModule::class, CiceroneModule::class, RepoModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: MainPresenter)


}