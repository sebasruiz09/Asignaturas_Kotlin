package com.school.asignaturas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityAyuda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        Components()
    }

    private fun Components(){
        var btnHelp:Button = findViewById(R.id.btnVolverAyuda)
        btnHelp.setOnClickListener{ OnClick(1) }
    }

    private fun OnClick(button:Int){
        when(button){
            1 -> { startActivity(Intent(this,ActivityHome::class.java)) }
        }
    }
}