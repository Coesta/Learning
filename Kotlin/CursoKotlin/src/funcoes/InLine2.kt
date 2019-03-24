package funcoes

inline fun<T> executarComLog(nomeFuncao: String, funcao:()-> T): T {
    println("Entrando no método $nomeFuncao...")
    try {
        return funcao()
    } finally {
        println("Método $nomeFuncao finalizado")
    }
}

fun somar2(a: Int, b: Int): Int {
    return a + b
}

fun main(args: Array<String>) {
    val resultado = executarComLog("somar") {
        somar2(4,5)
    }

    /*
    o escopo com as chaves se chama uma função anônima, ou
    uma função lambda. Nesse caso, a última linha (última
    sentença de código) da função é o retorno dela,
    ela tem um retorno implícito. Pode-se testar adicionando
    uma linha contendo um 2 + 3 e depois executar o código
    */

    println(resultado)
}