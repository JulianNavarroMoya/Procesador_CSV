package com.example.ud02cp02

fun main() {

    val filas = 'A'..'E'
    val columnas = 1..5

    val asientos: MutableMap<String, Boolean?> = mutableMapOf<String, Boolean?>()

    for (fl in filas) {
        for (col in columnas) {
            asientos["$fl$col"] = false
        }
    }

    var salir = false

    while (!salir) {
        println(
            """
            
            === CINE: SISTEMA DE RESERVAS ===
            1. Mostrar mapa
            2. Reservar
            3. Cancelar
            4. Salir
            Introduce una opción:
            """.trimIndent()
        )

    val opcion: Int = try {
        (readLine() ?: "").toInt()
    } catch (e: Exception) {
        -1
    }

    when (opcion) {
        1 -> {
        println("\n--- MAPA DE ASIENTOS ---")
        print("   ")
        for (col in columnas) {
            print("$col  ")
        }
        println()

        for (fl in filas) {
            print("$fl  ")
            for (col in columnas) {
                val clave = "$fl$col"
                val ocupado: Boolean? = asientos[clave]
                val simbolo = when (ocupado) {
                    true -> "[X]"
                    false -> "[O]"
                    null -> "[ ]"
                }
                print("$simbolo")
            }
            println()
        }
        println("Leyenda: [O] Disponible | [X] Ocupado | [ ] No existe")
    }

        2 -> {
            print("Introduce el asiento a reservar (ej. A1): ")
            val entrada: Any = readLine() ?: ""

            val codigoAsiento = (entrada as? String)?.trim()?.uppercase() ?: ""

            try {
                if (!asientos.containsKey(codigoAsiento)) {
                    println("Error: El asiento '$codigoAsiento' no existe.")
                } else {
                    val estadoActual = asientos[codigoAsiento]
                    when (estadoActual) {
                        true -> println("El asiento '$codigoAsiento' ya está ocupado.")
                        false -> {
                        asientos[codigoAsiento] = true
                        println("Asiento '$codigoAsiento' reservado con éxito.")
                    }
                        null -> println("Error: El asiento '$codigoAsiento' no existe.")
                    }
                }
            } catch (e: Exception) {
                println("Error al procesar la reserva: ${e.message}")
            }
        }

        3 -> {
            // Opción: Cancelar
            print("Introduce el asiento a cancelar (ej. A1): ")
            val entrada: Any = readLine() ?: ""
            val codigoAsiento = (entrada as? String)?.trim()?.uppercase() ?: ""

            try {
                if (!asientos.containsKey(codigoAsiento)) {
                    println("Error: El asiento '$codigoAsiento' no existe.")
                } else {
                    val estadoActual = asientos[codigoAsiento]
                    when (estadoActual) {
                        false -> println("El asiento '$codigoAsiento' ya está disponible (no estaba reservado).")
                        true -> {
                        asientos[codigoAsiento] = false
                        println("Reserva del asiento '$codigoAsiento' cancelada con éxito.")
                    }
                        null -> println("Error: El asiento '$codigoAsiento' no existe.")
                    }
                }
            } catch (e: Exception) {
                println("Error al cancelar la reserva: ${e.message}")
            }
        }

        4 -> {
            println("Saliendo del sistema de reservas...")
            salir = true
        }

        else ->
            println("Opción incorrecta. Por favor, selecciona una opción válida.")
        }
    }
}
