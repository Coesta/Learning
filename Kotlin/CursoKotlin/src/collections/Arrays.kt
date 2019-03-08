package collections

fun main() {
    val numeros = Array<Int>(10){i -> i * 10 }

    for (numero in numeros) {
        println(numero)
    }

    println(numeros.get(1))
    println(numeros[1])
    println(numeros.size)

    numeros.set(1, 123456)
    println(numeros.get(1))

    numeros[2] = 6546
    println(numeros[2])
}