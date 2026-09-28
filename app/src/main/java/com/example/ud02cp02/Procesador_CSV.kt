package com.example.ud02cp02

fun main(){
    val csv = """
    nombre,nota1,nota2,nota3
    Ana,7,8,9
    Luis,5,6,4
    Marta,9,10,8
""".trimIndent()

    val lineas = csv.split("\n")

    for (i in 1 until lineas.size) {

        val campos = lineas[i].split(",")
        val nombre = campos[0]

        val nota1 = campos[1].toDouble()
        val nota2 = campos[2].toDouble()
        val nota3 = campos[3].toDouble()

        val media = (nota1 + nota2 + nota3) / 3

        val calificacion = when {
            media >= 9 -> {
                "Sobresaliente"
            }
            media >= 7 -> {
                "Notable"
            }
            media >= 5 -> {
                "Aprobado"
            }
            else -> { "Suspenso" }
        }
        val fromato = String.format("%.2f",media)
        println(" alumno: $nombre | nota:($nota1,$nota2,$nota3) | media: $fromato | Calificacion: $calificacion |")
    }
}