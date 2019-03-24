package fundamentos

import fundamentos.pacoteA.simplesFuncao as funcaoSimples
import fundamentos.pacoteA.Coisa
import fundamentos.pacoteA.FaceMoeda.CARA
import fundamentos.pacoteB.* //vem tudo que tá no pacote

fun main(args: Array<String>) {
    kotlin.io.println(funcaoSimples("OK")) //por padrão já vem importado

    val coisa = Coisa("Bola")

    println(coisa.nome)

    println(CARA)

    println("${soma(2,3)} ${subtracao(4, 6)}")
}