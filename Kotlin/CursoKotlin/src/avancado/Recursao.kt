package avancado

import java.lang.IllegalArgumentException

fun fatorial(numero: Int): Int = if (numero >= 1) numero * fatorial(numero - 1) else 1
fun fatorialProfessor(num: Int): Int = when(num) {
    in 0..1 -> 1
    in 2..Int.MAX_VALUE -> num * fatorialProfessor(num - 1)
    else -> throw IllegalArgumentException("Número negativo")
}


fun main() {
    println("6! = ${fatorial(6)}")
    println("5! = ${fatorial(5)}")
    println("4! = ${fatorial(4)}")
    println("3! = ${fatorial(3)}")
    println("2! = ${fatorial(2)}")
    println("1! = ${fatorial(1)}")
    println("0! = ${fatorial(0)}")
    println("-1! = ${fatorial(-1)}")

    println("\n6! = ${fatorialProfessor(6)}")
    println("5! = ${fatorialProfessor(5)}")
    println("4! = ${fatorialProfessor(4)}")
    println("3! = ${fatorialProfessor(3)}")
    println("2! = ${fatorialProfessor(2)}")
    println("1! = ${fatorialProfessor(1)}")
    println("0! = ${fatorialProfessor(0)}")
    println("-1! = ${fatorialProfessor(-1)}")
}