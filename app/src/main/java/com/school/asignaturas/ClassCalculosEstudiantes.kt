package com.school.asignaturas

class ClassCalculosEstudiantes {

    companion object { var Estudiantes = arrayListOf<ClassDatosEstudiante>() }

    fun registrarEstudiantes( cdece:ClassDatosEstudiante ){ Estudiantes.add(cdece) }

    fun valorNotas (numero:Double):Boolean { return numero in 0.0 .. 5.0 }

    fun todosEstudiantes(): Int{ return Estudiantes.count() }

    fun todosPerdieron() : Int { return contadorEstados("No puede recuperar el periodo")}

    fun calcularPromedio(cdece: ClassDatosEstudiante): Double {
        var promedio = (cdece.nota1 + cdece.nota2 + cdece.nota3 + cdece.nota4 + cdece.nota5)/5
        return promedio
    }

    fun campoNotas (cdece: ClassDatosEstudiante): Boolean {
        return (valorNotas(cdece.nota1) === true &&
                valorNotas(cdece.nota2) === true &&
                valorNotas(cdece.nota3) === true &&
                valorNotas(cdece.nota4) === true &&
                valorNotas(cdece.nota5) === true)

    }

    fun ganoPerdioMateria(cdece: ClassDatosEstudiante): String {
        var estadoEstudiante = ""
        if(cdece.promedio > 3.5) { estadoEstudiante = "Gano el periodo" }
        else if(cdece.promedio > 2.5) { estadoEstudiante = "Puede recuperar el periodo" }
        else { estadoEstudiante = "No puede recuperar el periodo" }
        return estadoEstudiante
    }

    fun contadorEstados(estadoE:String): Int {
        var contadorE:Int = 0
        for (i in Estudiantes){ if(i.estadoEstudiante == estadoE){ contadorE++ } }
        return  contadorE
    }

}