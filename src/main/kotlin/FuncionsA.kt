fun billetes (billete: Int): String {
    return when (billete) {
        1 -> "Billete sencillo"
        2 -> "TCasual"
        3 -> "TUsual"
        4 -> "TFamiliar"
        5 -> "TJoven"
        else -> "Opción no válida"
    }
}

fun zonas (zona: Int): String {
    return when (zona) {
        1 -> "Zona 1"
        2 -> "Zona 2"
        3 -> "Zona 3"
        else -> "Opción no válida"
    }
}

fun calcularPrecioBillete(tipoBillete: Int, zonas: Int): Float {
    var precioBillete = 0.0F
    when (tipoBillete) {
        1 -> precioBillete = 1.5F
        2 -> precioBillete = 2.15F
        3 -> precioBillete = 3.6F
        4 -> precioBillete = 4.35F
        5 -> precioBillete = 6.7F
    }
    return precioBillete * zonas
}

