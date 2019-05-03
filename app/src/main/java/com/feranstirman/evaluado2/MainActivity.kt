package com.feranstirman.evaluado2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.feranstirman.evaluado2.fragmentos.fragmentBoton
import com.feranstirman.evaluado2.fragmentos.MainContentFragment

class MainActivity : AppCompatActivity(), fragmentBoton.SearchNewListener{



    //private lateinit var mainFragment: MainListFragment
    //private lateinit var mainContentFragment: MainContentFragment

    private lateinit var mainBotonesFragment: fragmentBoton
    private lateinit var mainImageFragment: MainContentFragment
    private var listaImagenes: ArrayList<String> = ArrayList()
    private var contador= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llenarListImagenes()
        iniciarFragmento()
    }

    private fun iniciarFragmento(){
     //   val recurso= R.id.portraitMain
        mainBotonesFragment= fragmentBoton.newInstance()
        changeFragment(R.id.botonesFragment, mainBotonesFragment)
        mainImageFragment= MainContentFragment.newInstance(listaImagenes[0])
        changeFragment(R.id.imagenFragment, mainImageFragment)
    }

    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }

    override fun clickSiguiente() {
        if(listaImagenes.size>contador+1) {
            mainImageFragment = MainContentFragment.newInstance(listaImagenes[contador + 1])
            contador++
            changeFragment(R.id.imagenFragment, mainImageFragment)
        }else{
            mainImageFragment = MainContentFragment.newInstance(listaImagenes[0])
            contador=0
            changeFragment(R.id.imagenFragment, mainImageFragment)
        }
    }

    override fun clickAtras() {
        if(contador-1>=0) {
            mainImageFragment = MainContentFragment.newInstance(listaImagenes[contador - 1])
            contador--
            changeFragment(R.id.imagenFragment, mainImageFragment)
        }else{
            mainImageFragment = MainContentFragment.newInstance(listaImagenes[listaImagenes.size-1])
            contador=listaImagenes.size-1
            changeFragment(R.id.imagenFragment, mainImageFragment)
        }
    }

    private fun llenarListImagenes(){
        listaImagenes.add("https://cdn.pixabay.com/photo/2017/08/04/10/36/background-2579719_960_720.jpg")
        listaImagenes.add("https://images.all-free-download.com/images/graphiclarge/blue_sea_water_background_187019.jpg")
        listaImagenes.add("https://i.stack.imgur.com/5lZ44.jpg")
        listaImagenes.add("https://www.lifewire.com/thmb/TfQXtH7x8j6hk6cH0DrPpxzS3AA=/400x250/filters:no_upscale():max_bytes(150000):strip_icc()/low-poly-background-672623312-5a5a8563e258f800370a105a-138616d9a1b0436a967ca4570b5dbb48.jpg")
    }


}
