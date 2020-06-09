const moduloA = require('../../moduloa') //no linux não funcionaria pq não é moduloA
console.log(moduloA.ola)

const c = require('./pastaC')
console.log(c.ola2)

//usando um módulo core do node
const http = require('http')
http.createServer((requisicao, resposta) => {
    resposta.write('Bom dia!')
    resposta.end()
}).listen(8080)