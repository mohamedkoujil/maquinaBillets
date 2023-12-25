/*

fun realizarCompra() {
    val maxBilletes = 3
    var contadorBilletes = 0
    var continuarPrograma = true
    while (contadorBilletes < maxBilletes && continuarPrograma) {
        println("Billete ${contadorBilletes + 1}:")
        menuTipoBillete()
        // Llamamos a menuNumeroBilletes con el contador actual y el mensaje correspondiente
        val confirmacionVolver = menuNumeroBilletes(contadorBilletes, "\nGracias por comprar ${contadorBilletes + 1} billete(s).")

        if (confirmacionVolver == 1) {
            // Si el usuario elige volver atrás, no incrementamos el contador y continuamos la iteración
            volverAtras("Volviendo atrás...", confirmacionVolver)
            continue
        }
        menuZonas()
        contadorBilletes++
        println("Lleva comprado $contadorBilletes billete/s")
        when (contadorBilletes) {
            2 -> println(BLACK_BOLD + "\nSolo podrá comprar un ticket más a partir de ahora, gracias" + RESET)
        }
        // Si ya se alcanza el número máximo de billetes, mostramos un mensaje y cambiamos continuarPrograma a false
        if (contadorBilletes >= maxBilletes) {
            println("Ha alcanzado el límite máximo de $maxBilletes billetes.")
            continuarPrograma = false
        } else {
            // Preguntamos si el usuario desea comprar otro billete
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
fun menuNumeroBilletes(contador: Int, mensajeCantidadBilletes: String): Int {
    val confirmacionVolver = readInt(
        "¿Desea volver atrás? (1: Sí, 0: No)",
        "Opción no válida",
        "Fuera del rango permitido",
        0,
        1
    )
    if (confirmacionVolver == 1) {
        // Si el usuario elige volver atrás, llamamos a la función menuTipoBillete
        volverAtras("Volviendo atrás...", confirmacionVolver)
    }
    return confirmacionVolver
}
fun volverAtras(mensajeVolver: String, confirmacion: Int) {
    if (confirmacion == 1) {
        println(mensajeVolver)
    }
}
*/
