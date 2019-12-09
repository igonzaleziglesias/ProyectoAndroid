package com.dam2.proyecto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_reto1.*
import kotlinx.android.synthetic.main.activity_reto4.*
import org.jetbrains.anko.toast

class Reto4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)

        var opcioncorrecta = 0
        opcion1.setOnClickListener{
            toast("OPCION1")
            opcioncorrecta=1
        }
        opcion2.setOnClickListener{
            toast("OPCION2")
            opcioncorrecta=2
        }
        opcion3.setOnClickListener{
            toast("OPCION3")
            opcioncorrecta=3
        }

        retorno.setOnClickListener{

            val data = Intent()
            data.putExtra("resp",opcioncorrecta.toString())
            //devolvemos la respuesta para comparar
            setResult(Activity.RESULT_OK,data)
            finish()//cerramos la activity

        }
    }
}
