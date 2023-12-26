fun titolColors(missatge: String) {
    val benvinguda = missatge.split("")
    val colors = arrayOf(YELLOW, GREEN, BLUE, PURPLE, CYAN, RED)
    var colorsIndex = 0
    for (i in benvinguda.indices) {

        print(colors[colorsIndex] + benvinguda[i] + RESET)

        // If there are more letters than colors, colorsIndex is reset to 0 to avoid errors
        if (colorsIndex == colors.indices.last) colorsIndex = 0
        else colorsIndex++
    }
    println()
}

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
        1 -> precioBillete = 2.4F
        2 -> precioBillete = 11.35F
        3 -> precioBillete = 40.0F
        4 -> precioBillete = 10.0F
        5 -> precioBillete = 80.0F
    }
    return precioBillete * zonas
}

fun factura (factura: MutableList<String>, total: Float, totalPagado: Float) {
    println("METROS ITB")
    println("Factura: ")
    println("---------------------------------")
    for (detalle in factura.indices) {
        println("${detalle+1}. ${factura[detalle]}")
    }
    println("Total: %.2f€".format(total))
    println("Ingreso: %.2f€".format(totalPagado))
    println("Cambio: %.2f€".format(totalPagado - total))
    println("---------------------------------")

}