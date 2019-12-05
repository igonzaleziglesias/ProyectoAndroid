package com.dam2.proyecto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto3.*

class Reto3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)

        var num1 = valor1.text//primera raiz
        var num2 = valor2.text//segunda raiz

        confirmar.setOnClickListener{

            val data = Intent()

            data.putExtra("resp1",num1.toString())//pasamos la primera raiz
            data.putExtra("resp2",num2.toString())//pasamos la segunda raiz

            //devolvemos la respuesta para comparar
            setResult(Activity.RESULT_OK,data)
            finish()//cerramos la activity


        }
    }
}
