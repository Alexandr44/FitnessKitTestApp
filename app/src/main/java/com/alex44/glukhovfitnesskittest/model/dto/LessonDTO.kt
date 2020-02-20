package com.alex44.glukhovfitnesskittest.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonDTO (
    @Expose @SerializedName("name") val name : String? = null,
    @Expose @SerializedName("description") val description : String? = null,
    @Expose @SerializedName("place") val place : String? = null,
    @Expose @SerializedName("teacher") val teacher : String? = null,
    @Expose @SerializedName("startTime") val startTime : String? = null,
    @Expose @SerializedName("endTime") val endTime : String? = null,
    @Expose @SerializedName("weekDay") val weekDay : Int? = null,
    @Expose @SerializedName("appointment_id") val appointmentId : String? = null,
    @Expose @SerializedName("service_id") val serviceId : String? = null,
    @Expose @SerializedName("pay") val pay : Boolean? = null,
    @Expose @SerializedName("appointment") val appointment : Boolean? = null,
    @Expose @SerializedName("teacher_v2") val teacherInfo : TeacherDTO? = null,
    @Expose @SerializedName("color") val color : String? = null,
    @Expose @SerializedName("availability") val availability : Int? = null
) : Serializable