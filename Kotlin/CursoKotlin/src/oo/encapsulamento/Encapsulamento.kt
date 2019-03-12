package oo.encapsulamento


// variáveis


private val dentroDoArquivo = 1
//protected val protegidoNaoSuportadoAqui = 1
internal val dentroDoProjeto = 1
val publico = 1

//funções

private fun dentroDoArquivo() = 1
//protected val protegidoNaoSuportadoAqui() = 1
internal fun dentroDoProjeto() = 1
fun publico() = 1

open class Capsula {
    private val dentroDoOjeto = 1
    protected val vaiPorHeranca = 1
    internal val dentroDoProjeto = 1
    val publico = 1

    private fun dentroDoOjeto() = 1
    protected fun vaiPorHeranca() = 1
    internal fun dentroDoProjeto() = 1
    fun publico() = 1
}

class CapsulaFilha: Capsula() {
    fun verificarAcesso() {
//        println(dentroDoOjeto)
//        println(Capsula().vaiPorHeranca)
        println(vaiPorHeranca)
        println(dentroDoProjeto)
        println(publico)
    }
}

fun verificarAcesso() {
//    println(Capsula().dentroDoObjeto())
//    println(Capsula().vaiPorHerancao())
    println(Capsula().dentroDoProjeto())
    println(Capsula().publico())
}