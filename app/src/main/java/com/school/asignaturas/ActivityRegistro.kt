package com.school.asignaturas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ActivityRegistro : AppCompatActivity() {

    var documentoE: EditText?=null
    var nombreE:EditText?=null
    var edadE:EditText?=null
    var direccionE:EditText?=null
    var telefonoE:EditText?=null

    var materiaE1:EditText?=null
    var materiaE2:EditText?=null
    var materiaE3:EditText?=null
    var materiaE4:EditText?=null
    var materiaE5:EditText?=null

    var notaE1:EditText?=null
    var notaE2:EditText?=null
    var notaE3:EditText?=null
    var notaE4:EditText?=null
    var notaE5:EditText?=null

    var calculos:ClassCalculosEstudiantes? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        getDatosEstudiante()
        VolverRegistro()
    }

    private fun VolverRegistro(){
        var btnVolverRegistro:Button = findViewById(R.id.btnVolverRegistro)
        btnVolverRegistro.setOnClickListener { OnClickVolverRegistro(1) }
    }

    private fun OnClickVolverRegistro(button:Int){
        when(button){
            1 -> { startActivity(Intent(this,ActivityHome::class.java)) }
        }
    }

    private fun getDatosEstudiante(){
        calculos = ClassCalculosEstudiantes()

        documentoE = findViewById(R.id.iptDocumento)
        nombreE = findViewById(R.id.iptNombre)
        edadE = findViewById(R.id.iptEdad)
        direccionE = findViewById(R.id.iptDireccion)
        telefonoE = findViewById(R.id.iptTelefono)

        materiaE1 = findViewById(R.id.txtMateria1)
        materiaE2 = findViewById(R.id.txtMateria2)
        materiaE3 = findViewById(R.id.txtMateria3)
        materiaE4 = findViewById(R.id.txtMateria4)
        materiaE5 = findViewById(R.id.txtMateria5)

        notaE1 = findViewById(R.id.iptNota1)
        notaE2 = findViewById(R.id.iptNota2)
        notaE3 = findViewById(R.id.iptNota3)
        notaE4 = findViewById(R.id.iptNota4)
        notaE5 = findViewById(R.id.iptNota5)

        val btnEnviar:Button = findViewById(R.id.btnEnviarDatos)
        btnEnviar.setOnClickListener { registrarEstudiante() }
    }

    private fun registrarEstudiante() {
        var cdere:ClassDatosEstudiante = ClassDatosEstudiante()

        if(documentoE?.text.toString() == "" || nombreE?.text.toString() == "" || edadE?.text.toString() == "" || direccionE?.text.toString() == "" || telefonoE?.text.toString() == "" || materiaE1?.text.toString() == "" || materiaE2?.text.toString() == "" || materiaE3?.text.toString() == "" || materiaE4?.text.toString() == "" || materiaE5?.text.toString() == "" || notaE1?.text.toString() == "" || notaE2?.text.toString() == "" || notaE3?.text.toString() == "" || notaE4?.text.toString() == "" || notaE5?.text.toString() == ""){
            Toast.makeText(this,"Por favor completar todos los campos.",Toast.LENGTH_LONG).show()
        }else{
            cdere.documento = documentoE?.text.toString()
            cdere.nombre = nombreE?.text.toString()
            cdere.edad = edadE?.text.toString().toInt()
            cdere.direccion = direccionE?.text.toString()
            cdere.telefono = telefonoE?.text.toString()

            cdere.materia1 = materiaE1?.text.toString()
            cdere.materia2 = materiaE2?.text.toString()
            cdere.materia3 = materiaE3?.text.toString()
            cdere.materia4 = materiaE4?.text.toString()
            cdere.materia5 = materiaE5?.text.toString()

            cdere.nota1 = notaE1?.text.toString().toDouble()
            cdere.nota2 = notaE2?.text.toString().toDouble()
            cdere.nota3 = notaE3?.text.toString().toDouble()
            cdere.nota4 = notaE4?.text.toString().toDouble()
            cdere.nota5 = notaE5?.text.toString().toDouble()

            cdere.promedio = calculos!!.calcularPromedio(cdere)
            cdere.estadoEstudiante = calculos!!.ganoPerdioMateria(cdere)

            if(calculos?.campoNotas(cdere) === true){
                calculos?.registrarEstudiantes(cdere)
                enviarDatosEstudiante(cdere)
            }else{ Toast.makeText(this, "Los numeros permitidos van del 0 al 5", Toast.LENGTH_SHORT).show() }
        }
    }

    private fun enviarDatosEstudiante(cdere:ClassDatosEstudiante) {
        val intent = Intent(this,ActivityVerDatos::class.java)
        val bundle:Bundle = Bundle()

        bundle.putString("nombreE",cdere.nombre)

        bundle.putString("materia1",cdere.materia1)
        bundle.putString("materia2",cdere.materia2)
        bundle.putString("materia3",cdere.materia3)
        bundle.putString("materia4",cdere.materia4)
        bundle.putString("materia5",cdere.materia5)

        bundle.putDouble("nota1",cdere.nota1)
        bundle.putDouble("nota2",cdere.nota2)
        bundle.putDouble("nota3",cdere.nota3)
        bundle.putDouble("nota4",cdere.nota4)
        bundle.putDouble("nota5",cdere.nota5)

        bundle.putString("ganoPerdio",cdere.estadoEstudiante)
        bundle.putDouble("promedioE", cdere.promedio)

        intent.putExtras(bundle)
        startActivity(intent)
    }
}