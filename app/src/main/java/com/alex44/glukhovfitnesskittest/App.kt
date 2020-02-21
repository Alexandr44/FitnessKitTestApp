package com.alex44.glukhovfitnesskittest

import android.app.Application
import com.alex44.glukhovfitnesskittest.common.model.db.DatabaseRoom
import com.alex44.glukhovfitnesskittest.di.AppComponent
import com.alex44.glukhovfitnesskittest.di.DaggerAppComponent
import com.alex44.glukhovfitnesskittest.di.modules.AppModule
import timber.log.Timber

class App : Application() {

    companion object{
        lateinit var instance : App
    }

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        DatabaseRoom.create(applicationContext)
    }

}