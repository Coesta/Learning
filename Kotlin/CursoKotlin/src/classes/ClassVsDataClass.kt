package classes

class Geladeira(val marca: String, val litros: Int)
data class Televisao(val marca: String, val polegadas: Int)

fun main(args: Array<String>) {
    val g1 = Geladeira("Brastemp", 320)
    val g2 = Geladeira("Brastemp", 320)

    println(g1 == g2) // compara referência de memória

    val tv1 = Televisao("Samsung", 32)
    val tv2 = Televisao("Samsung", 32)

    println(tv1 == tv2) // compara os dados, os atributos
    println(tv1 === tv2)

    println(g1.toString())
    println(tv1.toString()) // mostra o conteúdo do objeto... vem implementado no data class

    println(tv1.copy())
    println(tv1.copy(polegadas = 42))

    val (marca, polegada) = tv1 // destructuring em data class
    println("$marca $polegada")
}