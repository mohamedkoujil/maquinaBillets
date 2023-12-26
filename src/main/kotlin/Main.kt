
fun main() {

        val arteAscii = """
  _________
 | .-----. |
 ||       ||
 ||       ||
 |'-------'|
 |_|__|__|_|
  (o)---(o)
Metros Mohammed
Venta de Billetes
    """.trimIndent()

        println(arteAscii+"\n")

    val factura: MutableList<String> = mutableListOf()
    var numBilletes = 0
    do {
        var billete = 0
        var zona = 0

        do {
            billete = readInt("Bienvenido a la venta de billetes. Recuerde que, como máximo, podrá comprar " +
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

        println("Ha escogido: ${billetes(billete)}, ${zonas(zona)}")

        val eleccionFinalUsuario = readInt("1. Seguir comprando\n" +
                "2. Pagar\n" +
                "3. Cancelar elección",
            "Opción no válida",
            "Fuera del rango permitido",
            1,
            3)

        if (eleccionFinalUsuario != 3) factura.add( "${billetes(billete)} ${zonas(zona)}")
    } while (eleccionFinalUsuario != 2)
    println(factura)
}
