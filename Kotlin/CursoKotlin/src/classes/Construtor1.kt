package classes

class Filme {
    val nome: String
    val anoLancamento: Int
    val genero: String

    constructor(nome: String, ano: Int, genero: String = "Drama") {
        this.nome = nome
        this.anoLancamento = ano
        this.genero = genero
    }
}

fun main(args: Array<String>) {
    val filme = Filme("O Poderoso Chefão", 1972)
    println("O ${filme.genero }$ {filme.nome} foi lançado em ${filme.anoLancamento}")
}