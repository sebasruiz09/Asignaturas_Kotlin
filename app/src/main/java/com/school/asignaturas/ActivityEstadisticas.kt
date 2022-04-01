package com.school.asignaturas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityEstadisticas : AppCompatActivity() {

    var eProcesados:TextView? = null
    var eGanaron:TextView? = null
    var ePerdieron:TextView? = null
    var ePuedeRecuperar:TextView? = null
    var eCalculos:ClassCalculosEstudiantes? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        Volver()
        Estadisticas()
    }

    private fun Volver(){
        var btnEstadisticas: Button = findViewById(R.id.btnVolverEstadisticas)
        btnEstadisticas.setOnClickListener{ OnClick(1) }
    }

    private fun OnClick(button:Int){
        when(button){
            1 -> { startActivity(Intent(this,ActivityHome::class.java)) }
        }
    }

    private fun Estadisticas() {
        eCalculos = ClassCalculosEstudiantes()
        eProcesados = findViewById(R.id.editProcesados)
        eGanaron = findViewById(R.id.editGanaron)
        ePerdieron = findViewById(R.id.editPerdieron)
        ePuedeRecuperar = findViewById(R.id.editRecuperar)

        DatosEstadisticas()
    }

    private fun DatosEstadisticas(){
        eProcesados!!.text = eCalculos!!.todosEstudiantes().toString()
        eGanaron!!.text = eCalculos!!.contadorEstados("Gano el periodo").toString()
        ePerdieron!!.text = eCalculos!!.todosPerdieron().toString()
        ePuedeRecuperar!!.text = eCalculos!!.contadorEstados("Puede recuperar el periodo").toString()
    }
}