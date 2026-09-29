package com.example.ud02cp02
val listaTareas = mutableListOf<String>()

fun añadir(tarea: String) {
    listaTareas.add(tarea)
    println("Tarea añadida con éxito.")
}

fun completar(indice: Int) {
    if (indice in listaTareas.indices) {
        val tareaActual = listaTareas[indice]
        if (!tareaActual.startsWith("[X]")) {
            listaTareas[indice] = "[X] $tareaActual"
            println("Tarea marcada como completada.")
        } else {
            println("La tarea ya estaba completada.")
        }
    } else {
        println("Índice fuera de rango.")
    }
}

fun listar() {
    if (listaTareas.isEmpty()) {
        println("No hay tareas registradas.")
        return
    }
    println("\n--- LISTA DE TAREAS ---")
    for (i in listaTareas.indices) {
        println("${i + 1}. ${listaTareas[i]}")
    }
}

fun List<String>.pendientes(): List<String> {
    return this.filter { !it.startsWith("[X]") }
}

fun main() {
    var salir = false

    while (!salir) {
        println(
            """
            
            === GESTOR DE TAREAS ===
            1. Añadir tarea
            2. Completar tarea
            3. Listar todas las tareas
            4. Ver tareas pendientes
            5. Salir
            Elige una opción:
            """.trimIndent()
        )

        val opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
            print("Escribe la nueva tarea: ")
            val nuevaTarea = readLine()?.trim() ?: ""
            if (nuevaTarea.isNotBlank()) {
                añadir(nuevaTarea)
            } else {
                println("La tarea no puede estar vacía.")
            }
        }
            2 -> {
                listar()
                if (listaTareas.isNotEmpty()) {
                    print("Introduce el número de la tarea a completar: ")
                    val num = readLine()?.toIntOrNull() ?: 0
                    completar(num - 1)
                }
            }
            3 -> {
                listar()
            }
            4 -> {
                val tareasPendientes = listaTareas.pendientes()
                if (tareasPendientes.isEmpty()) {
                    println("¡No tienes tareas pendientes!")
                } else {
                    println("\n--- TAREAS PENDIENTES ---")
                    for (tarea in tareasPendientes) {
                        println("- $tarea")
                    }
                }
            }
            5 -> {
                println("Saliendo del gestor...")
                salir = true
            }
            else -> println("Opción no válida. Introduce un número del 1 al 5.")
        }
    }
}
