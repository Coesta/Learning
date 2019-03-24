package funcoes

// o param numeros se torna um Array de Inteiros nesse caso
fun ordenar(vararg numeros: Int, a: Int): IntArray{
    println("A = $a")
    return numeros.sortedArray()
}

fun main(args: Array<String>) {
    for (n in ordenar(38, 3, 456, 8, 51, 1, 88, 73, a = 1)){
        println("$n")
    }
}