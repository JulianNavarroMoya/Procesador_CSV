package com.example.ud02cp02

fun String.validarPassword(): Boolean {
    val errores = mutableListOf<String>()

    if (this.length < 8) {
        errores.add("( Debe tener al menos 8 caracteres )")
    }
    if (!this.any { it.isUpperCase() }) {
        errores.add("( Debe contener al menos una letra mayuscula )")
    }
    if (!this.any { it.isLowerCase() }) {
        errores.add("( Debe contener al menos una letra minuscula )")
    }
    if (!this.any { it.isDigit() }) {
        errores.add("( Debe contener al menos un digito )")
    }
    if (!this.any { !it.isLetterOrDigit() }) {
        errores.add("( Debe contener al menos un caracter especial")
    }

    return if (errores.isEmpty()) {
        true
    } else {
        println("La password no cumple los siguientes requisitos:")
        errores.forEach { error ->
            println("- $error")
        }
        false
    }
}

fun main() {
    var passwordValida = false

    do {
        print("Introduce una password: ")
        val entrada = readlnOrNull() ?: ""

        if (entrada.validarPassword()) {
            passwordValida = true
            println("password valida, Guardad con exito !!")
        }
    } while (!passwordValida)
}