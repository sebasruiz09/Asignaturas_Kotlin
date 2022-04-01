package com.school.asignaturas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ActivityHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Component()
    }

    private fun Component() {
        var btnRegistro2: Button = findViewById(R.id.btnRegistro2)
        var btnEstadisticas2: Button = findViewById(R.id.btnEstadisticas2)
        var btnAyuda2: Button = findViewById(R.id.btnAyuda2)

        btnRegistro2.setOnClickListener{ OnClick(1) }
        btnEstadisticas2.setOnClickListener { OnClick(2) }
        btnAyuda2.setOnClickListener { OnClick(3) }
    }

    private fun OnClick(button:Int) {
        when(button){
            1 -> { startActivity(Intent(this,ActivityRegistro::class.java)) }
            2 -> { startActivity(Intent(this,ActivityEstadisticas::class.java)) }
            3 -> { startActivity(Intent(this,ActivityAyuda::class.java)) }
        }
    }
}