package collections

fun main() {
    val alunos = arrayListOf("Amanda", "Luísa", "Bárbara", "Carla")

    for (aluno in alunos) {
        println(aluno)
    }

    for ((indice, aluno) in alunos.withIndex()) {
        println("$indice - $aluno")
    }

    for ((indice, aluno) in alunos.withIndex()){
        println("${indice + 1} - $aluno")   
    }
}