package fundamentos

fun main(args: Array<String>) {
    var a: Int?/*SafeCallOperator... Operador de chamada segura, onde a variável pode ter um valor nulo.*/ = null
    println(a?.dec())
}