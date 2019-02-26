package fundamentos.operadores

data class Carro(val marca: String, val modelo: String)

fun main(args: Array<String>) {

    /* os parênteses são "o operador de desestruturação"*/
    // contexto de objeto
    val (marca, modelo) = Carro("Ford", "Fusion")
    println("$marca $modelo")

    // agora no contexto de uma lista
    val(marido, mulher) = listOf("João", "Maria")
    println("$marido e $mulher")

    val(_, _, terceiroLugar) = listOf("Kimi", "Hamilton", "Alonso")
    println("$terceiroLugar terminou em terceiro lugar.")
}