package fundamentos.operadores

fun main(args: Array<String>) {
    var num1: Int = 1
    var num2: Int = 2

    num1++ // pós-fixado
    println(num1)
    --num1 // pré-fixado
    println(num1)

    // Incremento e decremento
    println(++num1 == num2--)
    /*num1 é incrementando antes da comparação e
    * num2 é decrementado depois da comparação.
    * A ordem de precedência é pré-fixado,
    * depois igualdade, depois pós-fixado*/

    println(num1 == num2)
}