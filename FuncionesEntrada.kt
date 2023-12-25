import org.example.RED_BACKGROUND_BRIGHT
import org.example.RESET
import java.util.*

/**
 * @param mensaje, Mensaje incial
 * @param maximo, le daremos un valor máximo razonable
 * @param minimo, y un mínimo para establecer
 */
fun recogidaLong(mensaje: String, minimo:Long, maximo:Long):Long {
    val SCAN = Scanner(System.`in`)
    var valor = 0
    var dato = false
    /**
     * A partir de aquí, nos aseguramos que los valores sean numéricos y esten entre un minimo
     * y un maximo
     */
    do {
        println(mensaje)
        dato = SCAN.hasNextInt()
        if (!dato) {
            println(RED_BACKGROUND_BRIGHT+"No es un carácter válido"+ RESET)
        } else {
            valor = SCAN.nextInt()
            if (valor < minimo || valor > maximo) {
                println(RED_BACKGROUND_BRIGHT+"Fuera de rango"+ RESET)
                dato = false
            }
        }
        SCAN.nextLine()
    } while (!dato)
    /**
     * Si hemos llegado aquí, significa que los datos son válidos y podemos almacenarlos en
     * @return valor
     */
    return valor.toLong()
}

/**
 * Hacemos exactamente lo mismo que arriba, pero con datos tipo String
 *
 */
fun recogidaString(mensaje: String): String {
    val SCAN = Scanner(System.`in`)
    var valor: String
    do {
        print(mensaje)
        valor = SCAN.nextLine()
        /**
         * Aquí evaluamos si @valor coincide o no con el rango de la A a la Z
         */
        if (!valor.matches(Regex("[a-zA-Z]+"))) {
            println(RED_BACKGROUND_BRIGHT + "No es una cadena válida. Por favor, ingresa solo letras." + RESET)
        }
        /**
         * Si valor no tiene valores de la A a la Z, se repetirá
         */
    } while (!valor.matches(Regex("[a-zA-Z]+")))
    return valor
}