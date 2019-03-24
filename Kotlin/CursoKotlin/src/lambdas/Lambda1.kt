package lambdas

fun main(args: Array<String>) {
    val soma = { x: Int, y: Int -> x + y }

    /*implicitamente a última sentença de códiogo é
      retornada numa função lambda...
      que é uma função anônima
    */

    println(soma(2, 3))
}