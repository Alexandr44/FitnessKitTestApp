package com.alex44.glukhovfitnesskittest.di.modules

import android.widget.ImageView
import com.alex44.glukhovfitnesskittest.common.interfaces.IImageLoader
import com.alex44.glukhovfitnesskittest.common.ui.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ImageModule {

    @Named("Glide")
    @Provides
    fun glideImageLoader() : IImageLoader<ImageView> = GlideImageLoader()

}