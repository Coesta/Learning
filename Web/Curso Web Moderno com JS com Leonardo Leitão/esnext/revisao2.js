// arrow function
const soma = (a, b) => a + b
console.log(soma(2, 3))

// arrow fuctions (this)
const lexico1 = () => console.log(this === exports)
const lexico2 = lexico1.bind({})
lexico1()
lexico2()

// parâmetro padrão
function log(texto = 'Node') {
    console.log(texto)
}

log()
log('Sou mais forte')

// operador rest
function total(...numeros) {
    let total = 0
    numeros.forEach(numero => total += numero)
    return total
}

console.log(total(2, 3, 4, 5))