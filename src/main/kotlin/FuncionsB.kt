import org.example.BLACK_BOLD
import org.example.RED_BRIGHT
import org.example.RESET
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