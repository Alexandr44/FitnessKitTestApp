package com.alex44.glukhovfitnesskittest.model.room.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.alex44.glukhovfitnesskittest.model.room.TeacherRoom

@Dao
interface TeacherDao {

    @Insert(onConflict = REPLACE)
    fun insert(newsArticle: TeacherRoom)

    @Insert(onConflict = REPLACE)
    fun insert(vararg newsArticles: TeacherRoom)

    @Insert(onConflict = REPLACE)
    fun insert(newsArticleList: List<TeacherRoom>)

    @Update
    fun update(newsArticle: TeacherRoom)

    @Update
    fun update(vararg newsArticles: TeacherRoom)

    @Update
    fun update(newsArticleList: List<TeacherRoom>)

    @Delete
    fun delete(newsArticle: TeacherRoom)

    @Delete
    fun delete(vararg newsArticles: TeacherRoom)

    @Delete
    fun delete(newsArticleList: List<TeacherRoom>)

    @Query("SELECT * FROM TeacherRoom t WHERE t.fullName LIKE :fio ORDER BY t.fullName LIMIT 1")
    fun findByFio(fio : String) : TeacherRoom?

}