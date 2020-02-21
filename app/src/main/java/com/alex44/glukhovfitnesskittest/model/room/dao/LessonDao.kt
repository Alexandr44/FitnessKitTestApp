package com.alex44.glukhovfitnesskittest.model.room.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.alex44.glukhovfitnesskittest.model.room.LessonRoom

@Dao
interface LessonDao {

    @Insert(onConflict = REPLACE)
    fun insert(newsArticle: LessonRoom)

    @Insert(onConflict = REPLACE)
    fun insert(vararg newsArticles: LessonRoom)

    @Insert(onConflict = REPLACE)
    fun insert(newsArticleList: List<LessonRoom>)

    @Update
    fun update(newsArticle: LessonRoom)

    @Update
    fun update(vararg newsArticles: LessonRoom)

    @Update
    fun update(newsArticleList: List<LessonRoom>)

    @Delete
    fun delete(newsArticle: LessonRoom)

    @Delete
    fun delete(vararg newsArticles: LessonRoom)

    @Delete
    fun delete(newsArticleList: List<LessonRoom>)

    @Query("SELECT * FROM LessonRoom l ORDER BY l.weekDay, l.startTime")
    fun findAll() : List<LessonRoom>?

    @Query("SELECT * FROM LessonRoom l WHERE l.serviceId LIKE :id")
    fun findByAppointmentId(id : String) : List<LessonRoom>?

}