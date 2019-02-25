package fundamentos

fun main(args: Array<String>) {
    var a: Int? = null

    println(a?.inc())

    println("Momento do Erro")
    println(a!!.inc()) // assumindo o risco de nullPointer
}