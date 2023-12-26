fun manejarPago(total: Float, totalPagado: Float): Float {
    var totalPagadoLocal = totalPagado // Variable local para acumular el total pagado

    while (totalPagadoLocal < total) {
        val pagoActual = readFloat("Por favor, introduzca el importe para pagar " +
                "(solo billetes de 5, 10, 20 o 50 euros, y monedas de 0.05, 0.10, 0.20, 0.50, 1 o 2 euros):",
            "Error: Introduzca una cantidad válida")

        if (!esCantidadValida(pagoActual)) {
            println("Cantidad no válida. Intente nuevamente.")
            continue
        }

        totalPagadoLocal += pagoActual
        println("Total pagado hasta ahora: %.2f€".format(totalPagadoLocal))
        var restante = total - totalPagadoLocal
        if (restante < 0) restante = 0F
        println("Importe restante: %.2f€".format(restante))
    }

    // Calcular y mostrar el cambio si es necesario
    val cambio = totalPagadoLocal - total
    println("Cambio: %.2f€".format(cambio))

    return totalPagadoLocal
}

fun esCantidadValida(cantidad: Float): Boolean {
    val monedasYBilletesValidos = setOf(0.05F, 0.10F, 0.20F, 0.50F, 1.0F, 2.0F, 5.0F, 10.0F, 20.0F, 50.0F)
    return monedasYBilletesValidos.contains(cantidad)
}

/*
fun realizarCompra() {
    val maxBilletes = 3
    var contadorBilletes = 0
    var continuarPrograma = true
    while (contadorBilletes < maxBilletes && continuarPrograma) {
        println("Billete ${contadorBilletes + 1}:")
        menuTipoBillete()
        val confirmacionVolver = NumeroBilletes(contadorBilletes, "\nGracias por comprar ${contadorBilletes + 1} billete(s).")
        if (confirmacionVolver == 1) {
            println("Volviendo atrás...")
            continue
        }
         menuZonas()
        contadorBilletes++
        println(RED_BRIGHT + "Lleva comprado $contadorBilletes billete/s" + RESET)
        when (contadorBilletes) {
            2 -> println(BLACK_BOLD + "\nSolo podrá comprar un ticket más a partir de ahora, gracias" + RESET)
        }
        if (contadorBilletes >= maxBilletes) {
            println("Ha alcanzado el límite máximo de $maxBilletes billetes.")
            continuarPrograma = false
        } else {
            val confirmacion = readInt("¿Desea comprar otro billete? (1: Sí, 0: No)", "Opción no válida", "Fuera del rango permitido", 0, 1)
            continuarPrograma = confirmacion == 1
        }
    }
    println("Gracias por su compra. Ha comprado un total de $contadorBilletes billete/s")
}
fun menuTipoBillete (){
    readInt("Bienvenido a la venta de billetes. Recuerde que, como máximo, podrá comprar" +
        "solamente tres billetes. Gracias\nPor favor, escoja una de las " +
        "siguientes opciones:\n" +
        "1.Billete sencillo\n" +
        "2.TCasual\n" +
        "3.TUsual\n" +
        "4.TFamiliar\n" +
        "5.TJoven\n",
    "Ópcion no válida",
    "Fuera del rango",
    1,
    5)
}
fun menuZonas(){
    readInt("Indique el número de zonas de su billete, por favor:",
        "Opción no válida",
        "Fuera del rango permitido",
        1,
        3)
}
fun NumeroBilletes(contador: Int, mensajeCantidadBilletes: String): Int {
    val confirmacionVolver = readInt(
        "¿Desea volver atrás? (1: Sí, 0: No)",
        "Opción no válida",
        "Fuera del rango permitido",
        0,
        1
    )
    return confirmacionVolver
}
 */