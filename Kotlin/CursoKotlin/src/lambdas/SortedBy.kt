package lambdas

fun main(args: Array<String>) {
    val nomes = arrayListOf("Renata", "Bernardo", "William", "Andreia", "Caio")
    val ordenados = nomes.sortedBy { it }
    val ordenacaoRevertida = nomes.sortedBy { it.reversed() }

    println(ordenados)
    println(ordenacaoRevertida)
}