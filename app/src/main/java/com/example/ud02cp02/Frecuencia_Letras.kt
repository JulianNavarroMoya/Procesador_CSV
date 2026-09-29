package com.example.ud02cp02

fun main() {
    print("Introduce un texto: ")
    val entrada = readlnOrNull() ?: ""

    val frecuencias = mutableMapOf<Char, Int>()
    val textoNormalizado = entrada.lowercase()

    for (caracter in textoNormalizado) {
        if (caracter != ' ') {
            val conteoActual = frecuencias[caracter] ?: 0
            frecuencias[caracter] = conteoActual + 1
        }
    }

    val resultadoOrdenado = frecuencias.toList().sortedByDescending { it.second }

    println("\n--- Frecuencia de letras (orden descendente) ---")
    for ((letra, cantidad) in resultadoOrdenado) {
        println("'$letra' -> $cantidad vez/veces")
    }
}