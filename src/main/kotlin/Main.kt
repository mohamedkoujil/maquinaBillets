fun main() {
    println(RED + """
      _________
     | .-----. |
     ||       ||
     ||       ||
     |'-------'|
     |_|__|__|_|
      (o)---(o)""" + RESET)
    titolColors("   METROS ITB")
    titolColors("Venta de billetes")
    val factura: MutableList<String> = mutableListOf()
    var contadorBilletes = 0
    var total = 0.0F
    var totalPagado = 0.0F

    do {
        var tipoBillete = 0
        var zona = 0

        do {
            tipoBillete = readInt("Bienvenido a la venta de billetes. Recuerde que, como máximo, podrá comprar " +
                    "solamente tres billetes. Gracias\nPor favor, escoja una de las " +
                    "siguientes opciones:\n" +
                    "1. Billete sencillo\n" +
                    "2. TCasual\n" +
                    "3. TUsual\n" +
                    "4. TFamiliar\n" +
                    "5. TJoven",
                "Ópcion no válida",
                "Fuera del rango",
                1,
                5)

            zona = readInt("Indique el número de zonas de su billete, por favor:\n" +
                    "1. Zona 1\n"  +
                    "2. Zona 2\n" +
                    "3. Zona 3\n" +
                    "4. Volver atrás",
                "Opción no válida",
                "Fuera del rango permitido",
                1,
                4)
        } while (zona == 4)

        val precioBillete = calcularPrecioBillete(tipoBillete, zona)
        total += precioBillete // Agregar el precio del billete al total
        println("Ha escogido: ${billetes(tipoBillete)}, ${zonas(zona)}")
        println("Precio por zona: %.2f€".format(precioBillete))

        val eleccionFinalUsuario = readInt("1. Seguir comprando\n" +
                "2. Pagar\n" +
                "3. Cancelar elección",
            "Opción no válida",
            "Fuera del rango permitido",
            1,
            3)

        if (eleccionFinalUsuario != 3) {
            factura.add("${billetes(tipoBillete)} ${zonas(zona)} - %.2f€".format(precioBillete))
            contadorBilletes++
        }
    } while (eleccionFinalUsuario != 2)
    println("BILLETES: $contadorBilletes TOTAL: %.2f€".format(total)) // Imprimir el total al final

    // Pago y cambio
    totalPagado = manejarPago(total, totalPagado)

    val deseaFactura = readChar("Desea factura?[S/N]", "Opción no válida", 1)
    if (deseaFactura == 'S') factura(factura, total, totalPagado)
    println("Gracias por su compra")
}


