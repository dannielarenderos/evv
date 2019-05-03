package com.feranstirman.evaluado2.fragmentos


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.feranstirman.evaluado2.R
import kotlinx.android.synthetic.main.fragment_main_image.view.*


class MainContentFragment: Fragment() {

    lateinit var imagen: String

    companion object {
        fun newInstance(imagen: String): MainContentFragment{
            val newFragment = MainContentFragment()
            newFragment.imagen = imagen
            return newFragment
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main_image, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){

        Log.v("stringImagen", imagen)
        Glide.with(view).load(imagen)
            .placeholder(R.drawable.ic_launcher_background)
            .override(2000, 600)
            .into(view.ImViewFoto)
    }

}