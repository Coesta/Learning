package funcoes

class Operacoes{
    fun somar(a: Int, b: Int): Int{
        return a + b
    }
}

// função top level
fun somar(a: Int, b: Int): Int{
    return a + b
}

fun calcular(a: Int, b: Int, funcao: (Int, Int) -> Int):Int {
    return funcao(a, b)
}

fun main(args: Array<String>) {
    println(calcular(2,3, Operacoes()::somar)) // passando a referência de uma função como parametro para outra função
    println(calcular(2,3, ::somar)) // é passado sem os parênteses, pois está se passando a referência da função, com os parênteses seria o ato de invocar a função
}