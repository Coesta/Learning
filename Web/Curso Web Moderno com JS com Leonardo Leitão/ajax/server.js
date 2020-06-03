const bodyParser = require('body-parser')
const express = require('express')
const app = express()
const multer = require('multer')

app.use(express.static('.')) // disponibiliza os arquivos estáticos do projeto
app.use(bodyParser.urlencoded({ extended: true })) // se vier dados nesse formato ele faz o parser (tipo no caso de formulários)
app.use(bodyParser.json()) // se vier em formato json ele faz o parser para um objeto

const storage = multer.diskStorage({
    destination: function(req, file, callback) {
        callback(null, './upload')
    },
    filename: function (req, file, callback) {
        callback(null, `${Date.now()}_${file.originalname}`)
    }
})

const upload = multer({ storage }).single('arquivo')

app.post('/upload', (req, res) => {
    upload(req, res, err => {
        if (err) {
            return res.end('Ocorreu um erro.')
        }

        res.end('Concluído com sucesso.')
    })
})

app.post('/formulario', (req, res) => {
    res.send({
        ...req.body,
        id:1
    })
})

app.get('/parOuImpar', (req, res) => {
    // req.body
    // req.query
    // req.params
    const par = parseInt(req.query.numero) % 2 === 0
    res.send({
        resultado: par ? 'par' : 'impar'
    })
})

app.listen(8080, () => console.log('Executando...'))