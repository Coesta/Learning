package lambdas

fun main(args: Array<String>) {
    val listaComNulos: List<String?> = listOf("A", null, "C", null, "D")

    for (item in listaComNulos){
        item?.let {
            println(it)
        }

        /*
        * Obs.1: O que ignora os valores nulos não é a função LET, mas sim
        * o operador SafeCallOperator.
        *
        * Obs.2: O resultado do LET é um Unit, e não o objeto
        * que você está trabalhando (uma String para este caso).
        *
        * */
    }

}