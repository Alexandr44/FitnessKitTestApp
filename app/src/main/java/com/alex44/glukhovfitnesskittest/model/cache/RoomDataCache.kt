package com.alex44.glukhovfitnesskittest.model.cache

import com.alex44.glukhovfitnesskittest.common.model.db.DatabaseRoom
import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import com.alex44.glukhovfitnesskittest.model.dto.TeacherDTO
import com.alex44.glukhovfitnesskittest.model.room.LessonRoom
import com.alex44.glukhovfitnesskittest.model.room.TeacherRoom

class RoomDataCache : IDataCache {

    override fun getData(): List<LessonDTO> {
        val result = ArrayList<LessonDTO>()
        val lessonDao = DatabaseRoom.getInstance().getLessonDao()
        val teacherDao = DatabaseRoom.getInstance().getTeacherDao()

        val list = lessonDao.findAll()
        if (list.isNullOrEmpty()) return emptyList()

        for (lessonRoom in list) {
            val lessonDTO = LessonDTO()
            val teacherDTO = TeacherDTO()

            lessonDTO.name = lessonRoom.name
            lessonDTO.description = lessonRoom.description
            lessonDTO.place = lessonRoom.place
            lessonDTO.teacher = lessonRoom.teacher
            lessonDTO.startTime = lessonRoom.startTime
            lessonDTO.endTime = lessonRoom.endTime
            lessonDTO.weekDay = lessonRoom.weekDay
            lessonDTO.appointmentId = lessonRoom.appointmentId
            lessonDTO.serviceId = lessonRoom.serviceId
            lessonDTO.pay = lessonRoom.pay
            lessonDTO.appointment = lessonRoom.appointment
            lessonDTO.color = lessonRoom.color
            lessonDTO.availability = lessonRoom.availability

            lessonRoom.teacherFullName?.let {
                val teacherRoom = teacherDao.findByFio(it)
                teacherRoom?.let { teacher ->
                    teacherDTO.fullName = teacher.fullName
                    teacherDTO.shortName = teacher.shortName
                    teacherDTO.imageUrl = teacher.imageUrl
                    teacherDTO.position = teacher.position
                    lessonDTO.teacherInfo = teacherDTO
                }
            }
            result.add(lessonDTO)
        }
        return result
    }

    override fun putData(list: List<LessonDTO>) {
        val lessonDao = DatabaseRoom.getInstance().getLessonDao()
        val teacherDao = DatabaseRoom.getInstance().getTeacherDao()

        for (lesson in list) {
            if (lesson.appointmentId.isNullOrEmpty()) continue
            val lessonRoom = LessonRoom(appointmentId = lesson.appointmentId!!)
            lessonRoom.name = lesson.name
            lessonRoom.description = lesson.description
            lessonRoom.place = lesson.place
            lessonRoom.teacher = lesson.teacher
            lessonRoom.startTime = lesson.startTime
            lessonRoom.endTime = lesson.endTime
            lessonRoom.weekDay = lesson.weekDay
            lessonRoom.serviceId = lesson.serviceId
            lessonRoom.pay = lesson.pay
            lessonRoom.appointment = lesson.appointment
            lessonRoom.teacherFullName = lesson.teacherInfo?.fullName
            lessonRoom.color = lesson.color
            lessonRoom.availability = lesson.availability
            lessonDao.insert(lessonRoom)

            if (!lesson.teacherInfo?.fullName.isNullOrEmpty()) {
                val teacherRoom = TeacherRoom(fullName = lesson.teacherInfo?.fullName!!)
                teacherRoom.shortName = lesson.teacherInfo?.shortName
                teacherRoom.imageUrl = lesson.teacherInfo?.imageUrl
                teacherRoom.position = lesson.teacherInfo?.position
                teacherDao.insert(teacherRoom)
            }
        }
    }

}