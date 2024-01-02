import java.util.concurrent.TimeUnit

fun main() {
    // Secret number to exit the program in variables to be able to change it easily
    val numSecret = 4321
    var numSecretBoolean = false

    //loop to repeat the program until secret number is entered
    do {
        println(
            RED + """
          _________
         | .-----. |
         ||       ||
         ||       ||
         |'-------'|
         |_|__|__|_|
          (o)---(o)""" + RESET
        )
        titolColors("   METROS ITB")
        titolColors("Venta de billetes")

        //list of tickets bought
        val factura: MutableList<String> = mutableListOf()
        //number of tickets bought
        var contadorBilletes = 0
        //total price of the ticket
        var total = 0.0F
        //total paid
        var totalPagado = 0.0F

        do {
            var tipoBillete = 0
            var zona = 0

            //loop to print the menu each time the user wants to buy a ticket
            do {
                tipoBillete = readInt(
                    "Bienvenido a la venta de billetes. Recuerde que, como máximo, podrá comprar " +
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
                    5,
                    numSecret
                )
                if (tipoBillete == numSecret) {
                    numSecretBoolean = true
                    break
                }

                zona = readInt(
                    "Indique el número de zonas de su billete, por favor:\n" +
                            "1. Zona 1\n" +
                            "2. Zona 2\n" +
                            "3. Zona 3\n" +
                            "4. Volver atrás",
                    "Opción no válida",
                    "Fuera del rango permitido",
                    1,
                    4,
                    numSecret
                )
                if (zona == 4321) {
                    numSecretBoolean = true
                    break
                }
            } while (zona == 4)

            if (numSecretBoolean) break

            val precioBillete = calcularPrecioBillete(tipoBillete, zona)

            total += precioBillete // Add the price of the ticket to the total

            println("Ha escogido: ${billetes(tipoBillete)}, ${zonas(zona)}")
            println("Precio del billete: %.2f€".format(precioBillete))

            val eleccionFinalUsuario = readInt(
                "1. Seguir comprando\n" +
                        "2. Pagar\n" +
                        "3. Cancelar elección",
                "Opción no válida",
                "Fuera del rango permitido",
                1,
                3,
                numSecret
            )
            if (eleccionFinalUsuario == numSecret) {
                numSecretBoolean = true
                break
            }

            //if the user wants to cancel the purchase, the ticket is not added to the list
            if (eleccionFinalUsuario != 3) {
                factura.add("${billetes(tipoBillete)} ${zonas(zona)} - %.2f€".format(precioBillete))
                contadorBilletes++
            }

            //if the user wants to pay, the program ends
        } while (eleccionFinalUsuario != 2)

        if (numSecretBoolean) break

        println("BILLETES: $contadorBilletes TOTAL: %.2f€".format(total))

        // Checkout
        manejarPago(total, totalPagado)

        // Ask if the user wants a bill
        val deseaFactura = readChar("Desea factura?[S/N]", "Opción no válida", 1)

        if (deseaFactura == 'S') factura(factura, total, totalPagado)

        println("Gracias por su compra")

    } while (!numSecretBoolean)

    if (numSecretBoolean) println("Apagando...")
    TimeUnit.SECONDS.sleep(3)

}


