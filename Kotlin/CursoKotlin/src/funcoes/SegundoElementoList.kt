package funcoes

/* Será adicionada a seguinte funcionalidade:
   Obter o segundo elemento de uma lista
 */

// E é um nome qualquer, poderia ser "ABC"... enfim, qualquer coisa
fun <E> List<E>.segundoElementoOuNulo(): E? = if (this.size >= 2) this.get(1) else null

fun main(args: Array<String>) {
    val lista = listOf("João", "Maria", "Pedro")

    println(lista.segundoElementoOuNulo())
}