const porta = 3003

const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const bancoDeDados = require('./bancoDeDados')

app.use(bodyParser.urlencoded({ extended: true }))

app.get('/produtos', (requisicao, resposta, next) => {
    resposta.send(bancoDeDados.getProdutos()) // a resposta será convertida para JSON
})

app.get('/produtos/:id', (req, res, next) => {
    res.send(bancoDeDados.getProduto(req.params.id))
})

app.post('/produtos', (requisicao, resposta, next) => {
    const produto = bancoDeDados.salvarProduto({
        nome: requisicao.body.nome,
        preco: requisicao.body.preco
    })

    resposta.send(produto) //JSON
})

app.put('/produtos/:id', (requisicao, resposta, next) => {
    const produto = bancoDeDados.salvarProduto({
        id: requisicao.params.id,
        nome: requisicao.body.nome,
        preco: requisicao.body.preco
    })

    resposta.send(produto) //JSON
})

app.delete('/produtos/:id', (requisicao, resposta, next) => {
    const produto = bancoDeDados.excluirProduto(requisicao.params.id)
    resposta.send(produto) //JSON
})


app.listen(porta, () => {
    console.log(`Servidor executando na porta ${porta}!`)
})