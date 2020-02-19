package com.alex44.glukhovfitnesskittest.common.interfaces

interface IImageLoader<T> {

    fun loadInto(url : String, container : T, corners : Int)

}