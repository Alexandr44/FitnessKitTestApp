package com.alex44.glukhovfitnesskittest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex44.glukhovfitnesskittest.App
import com.alex44.glukhovfitnesskittest.R
import com.alex44.glukhovfitnesskittest.presenters.HomePresenter
import com.alex44.glukhovfitnesskittest.views.DayView
import kotlinx.android.synthetic.main.fragment_home_rv_item.view.*

class DaysAdapter(private val presenter : HomePresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DayHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_home_rv_item, parent, false)
        )
    }

    override fun getItemCount() = presenter.days.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dayHolder = holder as? DayHolder
        dayHolder?.apply {
            elementPosition = position
            presenter.bind(this)
            adapter = LessonsAdapter(presenter, elementPosition)
            itemView.lessons_rv.layoutManager = LinearLayoutManager(App.instance, LinearLayoutManager.VERTICAL, false)
            itemView.lessons_rv.adapter = adapter
        }
    }

    inner class DayHolder(val view : View) : RecyclerView.ViewHolder(view), DayView {

        var elementPosition : Int = 0

        var adapter : LessonsAdapter? = null

        override fun setDayName(name: String) {
            view.rv_day_name.text = name
        }

        override fun getItemPosition(): Int {
            return elementPosition
        }

    }

}