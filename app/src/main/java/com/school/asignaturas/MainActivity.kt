package com.school.asignaturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_Average)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        components()
    }

    private fun components() {
        var btnRegistro:Button = findViewById(R.id.btnRegistro)
        var btnEstadisticas:Button = findViewById(R.id.btnEstadisticas)
        var btnAyuda:Button = findViewById(R.id.btnAyuda)

        btnRegistro.setOnClickListener{ OnClick(1) }
        btnEstadisticas.setOnClickListener { OnClick(2) }
        btnAyuda.setOnClickListener { OnClick(3) }
    }

    private fun OnClick(button:Int) {
        when(button){
            1 -> { startActivity(Intent(this,ActivityRegistro::class.java)) }
            2 -> { startActivity(Intent(this,ActivityEstadisticas::class.java)) }
            3 -> { startActivity(Intent(this,ActivityAyuda::class.java)) }
        }
    }
}
