package funcoes

import java.util.*

data class Horario(val hora: Int, val minuto: Int, val segundo: Int)

fun agora(): Horario{
    val agora = Calendar.getInstance();

    with(agora) {
        return Horario(get(Calendar.HOUR), get(Calendar.MINUTE), get(Calendar.SECOND))
    }
}

/* aqui é uma simulação de múltiplos retornos
   usando o recurso do destructuring,
   visto que Kotlin não tem múltiplos retornos
   como recurso nativo da linguagem
 */
fun main(args: Array<String>) {
    val (hora, minuto, segundo) = agora()
    println("$hora:$minuto:$segundo")
}