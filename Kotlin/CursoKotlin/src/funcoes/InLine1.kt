package funcoes

/*
    Sempre que trabalhar com uma função inline, passar uma
    função como parametro, mas é possível passar mais params
 */
inline fun transacao(funcao:()-> Unit){
    println("abrindo transação")
    try {
        funcao()
    } finally {
        println("fechando transação")
    }
}

fun main(args: Array<String>) {
    transacao { //parenteses são opcionais quando só tem um paramtro, que nesse caso é uma função
        println("Executando SQL 1 ...")
        println("Executando SQL 2 ...")
        println("Executando SQL 3 ...")
    }

    /*
    transacao ({ // outra possibilidade de chamar a função
    println("Executando SQL 1 ...")
    println("Executando SQL 2 ...")
    println("Executando SQL 3 ...")
    })

    há outras possibilidades com mais params
     */
}