package fundamentos.controles

fun main(args: Array<String>) {
    val nota: Double = 8.3

    // Usando o operador range
    if (nota in 9.0..10.0){
        println("Fantástico")
    } else if (nota in 7.0..8.0) {
        println("Parabéns")
    } else if (nota in 4.0..6.0) {
        print("Tem como recuperar")
    } else if (nota in 0.0..3.0) {
        println("Te vejo no próximo semestre")
    } else {
        println("Nota inválida!")
    }

    /*PS: Valores inteiros são truncados no range,
    assim, se tiver 8.3 ele se torna 8,
    a não ser que seja definido double explicitamente
    na expressão do range, como feito acima.
    */

    //operador range é sempre do menor para o maior
    println(5 in 7..4)
    println(5 in 4..7)
}