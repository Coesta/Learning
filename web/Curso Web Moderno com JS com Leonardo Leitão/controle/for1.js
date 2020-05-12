let contador = 1

while (contador < 10) {
    console.log(`contador = ${contador}`)
    contador++
}

console.log('USANDO O FOR')

for (let i = 0; i < 10; i++) {
    console.log(`i = ${i}`)
}

const notas = [8.6, 5.1, 9.6, 4.5, 7.7]
for (let i = 0; i < notas.length; i++){
    console.log(`nota = ${notas[i]}`)
}