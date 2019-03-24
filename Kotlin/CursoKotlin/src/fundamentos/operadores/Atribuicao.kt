package fundamentos.operadores

fun main(args: Array<String>) {
    var a: Int = 7
    var b: Int = 3

    /*Atribuições*/
    b += a // b = b + a. Aditiva. [binário]
    b -= 4 // b = b - 4. Subtrativa [binário]
    b *= 2 // b = b * 2. Multiplicativa [binário]
    b /= 2 // b = b / 2. Divisiva [binário]
    b %= 2 // Operador módulo... "é o resto da divisão entre dois números"

    println(b)
}