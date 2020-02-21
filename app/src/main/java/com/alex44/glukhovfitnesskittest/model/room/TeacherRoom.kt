package com.alex44.glukhovfitnesskittest.model.room

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TeacherRoom (
    var shortName : String? = null,
    @NonNull
    @PrimaryKey
    var fullName : String,
    var position : String? = null,
    var imageUrl : String? = null
) : Serializable