package funcoes

fun imprimirMaior(a: Int, b: Int){
    println(Math.max(a, b))
}

fun imprimirMaior2(a: Int, b: Int): Unit {
    println(Math.max(a, b))
}

fun imprimirMaior3(a: Int, b: Int): Unit {
    println(Math.max(a, b))
}

fun imprimirMaior4(a: Int, b: Int): Unit {
    println(Math.max(a, b))
    return //sempre retorna Unit
}

fun imprimirMaior5(a: Int, b: Int) {
    println(Math.max(a, b))
    return Unit
}

fun main(args: Array<String>) {
    imprimirMaior(2,1)
    imprimirMaior2(2,1)
    imprimirMaior3(2,1)
    imprimirMaior4(2,1)
    imprimirMaior5(2,1).run { 2 > 4 }.run { println("Resultado = $this") } // expressão lambda
}