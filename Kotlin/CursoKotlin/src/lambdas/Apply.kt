package lambdas

class Calculadora2 {
    var resultado = 0

    fun somar(valor1: Int, valor2: Int){
        resultado += valor1 + valor2
    }

    fun add(valor: Int){
        resultado += valor
    }
}

fun main(args: Array<String>) {
    val calculadora = Calculadora2()

    calculadora.apply { somar(4,5).apply { add(5) } }.apply { println(resultado) }
    calculadora.apply {
        somar(4,5)
        add(5)
        println(resultado)
    }

    // inline function
    with(calculadora){
        somar(4,5)
        add(5)
        println(resultado)
    }

//    with(calculadora, { //outra possibilidade
//        somar(4,5)
//        add(5)
//        println(resultado)
//    })
}