let valor
console.log(valor) //undefined ... alguma linguagens não tem esse conceito
//console.log(valor2) // is not defined... ou seja, nem foi declarado

valor = null
console.log(valor)
//console.log(valor.toString()) // erro...

const produto = {}
console.log(produto.nome) //undefined

produto.preco = 3.5
console.log(produto)

produto.preco = undefined // evitar atribuir undefined
console.log(!!produto.preco)
//delete produto.preco
console.log(produto)

produto.preco = null // sem preço
console.log(!!produto.preco)
console.log(produto)