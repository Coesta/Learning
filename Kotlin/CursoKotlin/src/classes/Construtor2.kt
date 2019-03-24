package classes

class Filme2(val nome: String, val anoLancamento: Int, val genero: String)

fun main(args: Array<String>) {
    val filme = Filme2("Monstros S.A", 2001, "Comédia")
    println("${filme.genero}: ${filme.nome} foi lançado em ${filme.anoLancamento}")
}