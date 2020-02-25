package com.alex44.glukhovfitnesskittest.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex44.glukhovfitnesskittest.R
import com.alex44.glukhovfitnesskittest.presenters.HomePresenter
import com.alex44.glukhovfitnesskittest.views.LessonView
import kotlinx.android.synthetic.main.fragment_home_sub_rv_item.view.*

class LessonsAdapter(private val presenter : HomePresenter, private val dayIndex : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LessonHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_home_sub_rv_item, parent, false)
        )
    }

    override fun getItemCount() = presenter.days[dayIndex].lessons.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val lessonHolder = holder as? LessonHolder
        lessonHolder?.apply {
            elementPosition = position
            presenter.bind(this, dayIndex)
        }
    }

    inner class LessonHolder(private val view : View) : RecyclerView.ViewHolder(view), LessonView {

        var elementPosition : Int = 0

        override fun setLessonName(name: String) {
            view.lesson_name.text = name
        }

        override fun setDescription(description: String) {
            view.lesson_description.text = description
        }

        override fun getItemPosition(): Int {
            return elementPosition
        }

        override fun setTeacherName(name: String) {
            view.lesson_teacher.text = name
        }

        override fun setPlace(place: String) {
            view.lesson_place.text = place
        }

        override fun setStartTime(startTime: String) {
            view.lesson_time_start.text = startTime
        }

        override fun setEndTime(endTime: String) {
            view.lesson_time_end.text = endTime
        }

        override fun setColor(color: String) {
            view.lesson_card_view.setCardBackgroundColor(Color.parseColor(color))
        }

    }

}