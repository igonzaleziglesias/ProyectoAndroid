package com.dam2.proyecto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto1.*
import org.jetbrains.anko.browse

class Reto1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto1)


        link.setOnClickListener{
            browse("https://es.wikipedia.org/wiki/Crist%C3%B3bal_Col%C3%B3n")
        }
        val res = respuesta.text//cogemos la respuesta

        volver.setOnClickListener{

            val data = Intent()
            data.putExtra("resp",res.toString())
            //devolvemos la respuesta para comparar
            setResult(Activity.RESULT_OK,data)
            finish()//cerramos la activity

        }

    }

}