const escola = "cod3r"

console.log(escola.charAt(4))
console.log(escola.charAt(5)) // não gera erro
console.log(escola.charCodeAt(3)) //pega o valor do caracter na tabela ASCII / Unicode
console.log(escola.indexOf('o')) // verifica se o caracter está na string e retorna a posição

console.log(escola.substring(1)) // imprime tudo a partir do índice 1
console.log(escola.substring(0, 3)) // imprime de 0 a 2 (0 3 não é incluído)

console.log('Escola '.concat(escola).concat('!'))
console.log('Escola '+ escola + '!')
console.log(escola.replace(3, 'e'))

console.log('Maria, Pedro, João'.split(','))