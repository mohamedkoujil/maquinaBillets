import java.util.concurrent.TimeUnit
/**
 * This method can be used to print a String value in a colored way using ANSI escape codes
 * @author mohamedkoujil
 * @since 26/12/2023
 * @param missatge Input message to apply colors
 * @return print the message with colors
 */
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

/**
 * This method is used to print the type of ticket menu of the program and to read the user's choice, returning the type of ticket in String format.
 * @author mohamedkoujil
 * @since 26/12/2023
 * @param billete type of ticket
 * @return name of the type of ticket
 */
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

/**
 * This method is used to print the zones menu of the program and to read the user's choice, returning the number of zones string format.
 * @author mohamedkoujil
 * @since 26/12/2023
 * @param zona number of zones
 * @return name of the zones of the ticket
 */
fun zonas (zona: Int): String {
    return when (zona) {
        1 -> "Zona 1"
        2 -> "Zona 2"
        3 -> "Zona 3"
        else -> "Opción no válida"
    }
}

/**
 * This method is used tu calculate the price of the ticket depending on the type of ticket and the number of zones, returning the price of the ticket in Float format.
 * @author JesusCaballeroPr
 * @since 26/12/2023
 * @param tipoBillete type of ticket
 * @param zonas number of zones
 * @return price of the ticket
 */
fun calcularPrecioBillete(tipoBillete: Int, zonas: Int): Float {
    var precioBillete = 0.0F

    when (tipoBillete) {
        1 -> precioBillete = 2.4F
        2 -> precioBillete = 11.35F
        3 -> precioBillete = 40.0F
        4 -> precioBillete = 10.0F
        5 -> precioBillete = 80.0F
    }
    when (zonas) {
        2 -> precioBillete *= 1.3125F
        3 -> precioBillete *= 1.8443F
    }

    return precioBillete
}

/**
 * This method is used to manage the payment of the ticket, returning the total paid and remaining in Float format.
 * @author JesusCaballeroPr
 * @since 26/12/2023
 * @param total total price of the ticket
 * @param totalPagado total paid
 * @return total paid
 */
fun manejarPago(total: Float, totalPagado: Float): Float {
    var totalPagadoLocal = totalPagado // Local variable to accumulate the total paid

    // Loop to ask the user for the amount to pay until the total is paid
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

    // Calculate the change to be returned to the user, if any
    val cambio = totalPagadoLocal - total
    println("Cambio: %.2f€".format(cambio))

    return totalPagadoLocal
}

/**
 * This method is used to check if the amount entered by the user is valid, returning a Boolean value depending on whether it is valid or not.
 * @author JesusCaballeroPr
 * @since 26/12/2023
 * @param cantidad amount entered by the user
 * @return Boolean value depending on whether it is valid or not
 */
fun esCantidadValida(cantidad: Float): Boolean {
    val monedasYBilletesValidos = setOf(0.05F, 0.10F, 0.20F, 0.50F, 1.0F, 2.0F, 5.0F, 10.0F, 20.0F, 50.0F)
    return monedasYBilletesValidos.contains(cantidad)
}

/**
 * This method is used to print the bill, returning the ticket in String format with the total price, the amount paid and the change to be returned to the user in Float format.
 * @author mohamedkoujil
 * @since 26/12/2023
 * @param factura tickets bought
 * @param total total price of the ticket
 * @param totalPagado total paid
 * @return ticket with the total price, the amount paid and the change to be returned to the user
 */
fun factura (factura: MutableList<String>, total: Float, totalPagado: Float) {
    println("           METROS ITB")
    println("Factura: ")
    println("---------------------------------")
    for (detalle in factura.indices) {
        println("${detalle+1}. ${factura[detalle]}")
    }
    println("Total: %.2f€".format(total))
    println("Ingresado: %.2f€".format(totalPagado))
    println("Cambio: %.2f€".format(totalPagado - total))
    println("---------------------------------")
    TimeUnit.SECONDS.sleep(3) // Adding a 3-second delay

}