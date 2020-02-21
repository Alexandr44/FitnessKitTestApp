package com.alex44.glukhovfitnesskittest.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeacherDTO (
    @Expose @SerializedName("short_name") var shortName : String? = null,
    @Expose @SerializedName("name") var fullName : String? = null,
    @Expose @SerializedName("position") var position : String? = null,
    @Expose @SerializedName("imageUrl") var imageUrl : String? = null
) : Serializable