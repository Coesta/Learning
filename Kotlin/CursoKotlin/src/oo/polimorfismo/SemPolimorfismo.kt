package oo.polimorfismo

// Carro -> Civic, Ferrari, Fiesta
// var c: Carro = Civic()
// c = Ferrari()
// c = Fiesta()

class Feijao2(val peso: Double)
class Arroz2(val peso: Double)

class Pessoa2(var peso: Double) {
    fun comer(feijao: Feijao2) {
        peso += feijao.peso
    }

    fun comer(arroz: Arroz2) {
        peso += arroz.peso
    }
}

fun main() {
    val feijao = Feijao2(0.3)
    val arroz = Arroz2(0.3)

    val joao = Pessoa2(80.5)
    joao.comer(arroz)
    joao.comer(feijao)

    println(joao.peso)


}