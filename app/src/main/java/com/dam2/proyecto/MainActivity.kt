package com.dam2.proyecto

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.service.autofill.Validators.and
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_game_over.*

import kotlinx.android.synthetic.main.activity_reto1.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

const val PICK_RETO1_REQUEST = 1
const val PICK_RETO2_REQUEST = 2
const val PICK_RETO3_REQUEST = 3
const val PICK_RETO4_REQUEST = 4

var contador=0
var texto=""
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //COLOR DE LOS BOTONES
        boton1.setBackgroundColor(Color.LTGRAY)
        boton2.setBackgroundColor(Color.LTGRAY)
        boton4.setBackgroundColor(Color.LTGRAY)
        boton3.setBackgroundColor(Color.LTGRAY)

        //reto1

        boton1.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent = Intent(this, Reto1::class.java)//creamos el intent
            startActivityForResult(intent, PICK_RETO1_REQUEST)//iniciamos
        }

        //reto2
        boton2.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent2 = Intent(this, Reto2::class.java)//creamos el intent
            startActivityForResult(intent2, PICK_RETO2_REQUEST)//iniciamos
        }

        //reto3
        boton3.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent3 = Intent(this, Reto3::class.java)//creamos el intent
            startActivityForResult(intent3, PICK_RETO3_REQUEST)//iniciamos
        }

        //reto4
        boton4.setOnClickListener{
            //buscar con browser en internet en otra activity
            val intent4 = Intent(this, Reto4::class.java)//creamos el intent
            startActivityForResult(intent4, PICK_RETO4_REQUEST)//iniciamos
        }
        //terminar
        fin.setOnClickListener{
            //buscar con browser en internet en otra activity
            if (contador<2){
                //toast("HAS PERDIDO")
                texto="HAS PERDIDO"
            }else if (contador==2){
                //toast("NO ES SUFICIENTE")
                texto="NO ES SUFICIENTE"
            }else{
                //toast("HAS GANADO")
                texto="HAS GANADO"
            }

            boton1.setEnabled(true)//activamos los retos
            boton2.setEnabled(true)//activamos los retos
            boton3.setEnabled(true)//activamos los retos
            boton4.setEnabled(true)//activamos los retos
            boton1.setBackgroundColor(Color.LTGRAY)
            boton2.setBackgroundColor(Color.LTGRAY)
            boton4.setBackgroundColor(Color.LTGRAY)
            boton3.setBackgroundColor(Color.LTGRAY)
            val intent5 = Intent(this, GameOver::class.java)//creamos el intent
            startActivity(intent5)//iniciamos
            contador=0
        }

    }

    @SuppressLint("ResourceAsColor")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MisErrores","errores")

        //Reto1
        if (requestCode == PICK_RETO1_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("resp").toString()).equals("1506")){
                    boton1.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                    contador=contador+1
                }else {
                    boton1.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton1.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }

        //Reto2

        if (requestCode == PICK_RETO2_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getBooleanExtra("resp",false)!!.equals(true)){
                    boton2.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                    contador=contador+1

                }else {
                    boton2.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }





            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton2.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }




        //Reto3

        if (requestCode == PICK_RETO3_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("resp1").toString().equals("3"))and(data?.getStringExtra("resp2").toString()!!.equals("2"))){
                    boton3.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                    contador=contador+1

                }else if ((data?.getStringExtra("resp1").toString().equals("2"))and(data?.getStringExtra("resp2").toString()!!.equals("3"))){
                    boton3.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                    contador=contador+1

                }else {
                    boton3.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton3.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }

        //reto4
        if (requestCode == PICK_RETO4_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("resp").toString()).equals("2")){
                    boton4.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    Log.d("MisErrores","errores verde")
                    toast("CORRECTO")//toast informativa
                    contador=contador+1

                }else {
                    boton4.setBackgroundColor(Color.RED)//boton rojo= error
                    Log.d("MisErrores","errores rojo")
                    toast("INCORRECTO")//toast informativa
                }
            }else{
                respuesta.setText("Error al pasar datos")
            }
            boton4.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
