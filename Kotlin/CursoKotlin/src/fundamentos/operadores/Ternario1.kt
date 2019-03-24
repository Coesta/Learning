package fundamentos.operadores

fun main(args: Array<String>) {
    val nota: Double = 6.0

    // Simulação do ternário
    val resultado: String = if (nota >= 7) "Aprovado" else "Reprovado"
    println(resultado)
}