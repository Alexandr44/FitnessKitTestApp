package com.alex44.glukhovfitnesskittest.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeacherDTO (
    @Expose @SerializedName("short_name") val shortName : String? = null,
    @Expose @SerializedName("name") val fullName : String? = null,
    @Expose @SerializedName("position") val position : String? = null,
    @Expose @SerializedName("imageUrl") val imageUrl : String? = null
) : Serializable