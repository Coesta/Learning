package fundamentos.funcoes

fun min(a: Int, b: Int): Int = if(a < b) a else b

fun main(args: Array<String>) {
    println("O menor valor é ${min(7, 4)}")
}