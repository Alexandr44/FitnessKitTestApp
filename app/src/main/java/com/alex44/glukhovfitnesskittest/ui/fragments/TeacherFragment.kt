package com.alex44.glukhovfitnesskittest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.alex44.glukhovfitnesskittest.App
import com.alex44.glukhovfitnesskittest.R
import com.alex44.glukhovfitnesskittest.common.interfaces.BackButtonListener
import com.alex44.glukhovfitnesskittest.common.interfaces.IImageLoader
import com.alex44.glukhovfitnesskittest.model.dto.TeacherDTO
import com.alex44.glukhovfitnesskittest.presenters.TeacherPresenter
import com.alex44.glukhovfitnesskittest.views.TeacherView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_teacher.*
import javax.inject.Inject
import javax.inject.Named


class TeacherFragment : MvpAppCompatFragment(), TeacherView, BackButtonListener{

    @InjectPresenter
    lateinit var presenter: TeacherPresenter

    @field: [Inject Named("Glide")]
    lateinit var imageLoader : IImageLoader<ImageView>

    companion object {
        fun newInstance(teacherDTO: TeacherDTO) : TeacherFragment {
            val arguments = Bundle()
            arguments.putSerializable("teacherInfo" ,teacherDTO)
            val fragment = TeacherFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.instance.appComponent.inject(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher, container, false)
    }

    @ProvidePresenter
    fun createPresenter() : TeacherPresenter {
        val teacherDTO = arguments?.getSerializable("teacherInfo") as? TeacherDTO
        val presenter = TeacherPresenter(teacherDTO)
        App.instance.appComponent.inject(presenter)
        return presenter
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun setImage(url: String) {
        imageLoader.loadInto(url, teacher_image, 40)
    }

    override fun setFio(fio: String) {
        teacher_fio.text = fio
    }

    override fun setPosition(position: String) {
        teacher_position.text = position
    }

    override fun backClick(): Boolean {
        return presenter.backClicked()
    }

}
