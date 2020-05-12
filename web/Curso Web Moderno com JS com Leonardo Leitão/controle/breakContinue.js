const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

console.log('Usando o BREAK') // interrompe o laço e vai pra próxima sentença

for (let i in numeros) {
    if (i == 5) {
        break
    }

    console.log(`${i} = ${numeros[i]}`)
}

console.log('Usando o CONTINUE') // pula o laço atual e e vai para o próximo laço

for (let i in numeros) {
    if (i == 5) {
        continue
    }

    console.log(`${i} = ${numeros[i]}`)
}

externo: for (a in numeros) {
    for (b in numeros) {
        if (a == 2 && b == 3) break externo
        console.log(`Par ${a} e ${b}`)
    }
}