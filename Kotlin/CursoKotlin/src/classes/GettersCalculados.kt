package classes

class Produto(val nome: String, var preco: Double, var desconto: Double, var ativo: Boolean){
    val inativo: Boolean get() = !ativo
    val precoComDesconto: Double get() = preco * (1 - desconto)
}

fun main(args: Array<String>) {
    val p1 = Produto("Ipad", 2348.9, desconto = 0.20, ativo = true)
    println(p1.precoComDesconto)

    val p2 = Produto("Galaxy Note 7", 2684.68, .5, ativo = false)
    println("${p2.nome}\n\t De: R$ ${p2.preco}\n\t Por: R$${p2.precoComDesconto}")

    if (p2.inativo){
        p2.preco = 0.0
        println("Depois de Inativo: R$ ${p2.precoComDesconto}")
    }
}