package classes

class Cliente2{
    constructor(nome: String) {
        this.nome = nome
    }

    var nome: String
        get() = "Meu nome é $field"
        set(value) {
            field = value.takeIf { value.isNotEmpty() } ?: "Anônimo" // lambda ... função anônima com operador elvis
        }

}

fun main(args: Array<String>) {
    val c2 = Cliente2("")
    println(c2.nome)

    val ccc2 = Cliente2("Pedro")
    println(ccc2.nome)
    ccc2.nome = "Ana"
    println(ccc2.nome)
}