package collections

fun Any.print() = println(this)

fun main() {
    val conjunto = hashSetOf(10, 'f', "texto", true, 3.14)

    // conjunto.get(1) não é possível obter pois o set não é indexado

    conjunto.add(10).print() // retorna false pq o SET não aceita repetição de elementos
    conjunto.add(3).print()

    conjunto.size.print()

    conjunto.remove('f').print()

    conjunto.contains('f').print()
    conjunto.contains("texto").print()

    val nums = setOf(1 ,2 ,3) // conjunto somente leitura
    //nums.add(4)

    (conjunto + nums).print()
    (conjunto - nums).print()

    conjunto.intersect(nums).print() // não muda o conjunto, na realidade gera outro conjunto que pode ser armazenado em outro variável
    conjunto.retainAll(nums).print() // muda o conjunto

    conjunto.clear().print()
    conjunto.isEmpty().print()
}