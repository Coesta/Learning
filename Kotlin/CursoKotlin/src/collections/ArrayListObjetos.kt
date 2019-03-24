package collections

data class Fruta (var nome: String, var preco: Double)

fun main() {
    val frutas = arrayListOf(Fruta("Banana",  1.50), Fruta("Morango", 3.20))

    for (fruta in frutas) {
        println("${fruta.nome} - R$ ${fruta.preco}")
    }

    println(frutas.contains(Fruta("Banana",  1.50)))  // true por causa do data class que implementa o equals, se não fosse data class seria false
    println(frutas.distinctBy { it.preco })
}