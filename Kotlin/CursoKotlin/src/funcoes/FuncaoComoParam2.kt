package funcoes

fun <E> filtrar(listaOriginal: List<E>, filtro: (E) -> Boolean): List<E> {
    var listaFiltrada = ArrayList<E>()
    for (itemLista in listaOriginal){
        if (filtro(itemLista)){
            listaFiltrada.add(itemLista)
        }
    }

    return listaFiltrada
}

fun comTresLetras(nome: String): Boolean{
    return nome.length == 3
}

fun main(args: Array<String>) {
    val nomes = listOf("Ana", "Pedro", "Bia", "Gui", "Rebeca")
    println(filtrar(nomes, ::comTresLetras))
}