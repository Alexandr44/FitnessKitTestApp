package com.alex44.glukhovfitnesskittest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.alex44.glukhovfitnesskittest.App
import com.alex44.glukhovfitnesskittest.R
import com.alex44.glukhovfitnesskittest.presenters.HomePresenter
import com.alex44.glukhovfitnesskittest.ui.adapters.DaysAdapter
import com.alex44.glukhovfitnesskittest.views.HomeView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : MvpAppCompatFragment(), HomeView {

    @InjectPresenter
    lateinit var presenter: HomePresenter

    var adapter : DaysAdapter? = null

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @ProvidePresenter
    fun createPresenter() : HomePresenter {
        val presenter = HomePresenter(AndroidSchedulers.mainThread())
        App.instance.appComponent.inject(presenter)
        return presenter
    }

    override fun initRV() {
        adapter = DaysAdapter(presenter)
        days_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        days_rv.adapter = adapter
        days_rv_indicator.attachToRecyclerView(days_rv)
        val helper = LinearSnapHelper()
        helper.attachToRecyclerView(days_rv)
    }

    override fun updateRV() {
        adapter?.notifyDataSetChanged()
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        presenter.rvPosition = (days_rv?.layoutManager as? LinearLayoutManager)?.findFirstCompletelyVisibleItemPosition()?:0
    }

    override fun onResume() {
        super.onResume()
        (days_rv?.layoutManager as? LinearLayoutManager)?.scrollToPosition(presenter.rvPosition)
    }

}
