package com.dam2.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        gameover.setText(texto)
        reintentar.setOnClickListener{
            finish()
        }
    }
}
