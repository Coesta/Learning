for (let letra of "Cod3r") {
    console.log(letra)
}

const assuntoEcma = ['Map', 'Set', 'Promise']

for (let i in assuntoEcma) {
    console.log(i)
}

for (let assunto of assuntoEcma) {
    console.log(assunto)
}

const assuntosMap = new Map([
    ['Map', { abordado: true }],
    ['Set', { abordado: true }],
    ['Promise', { abordado: false }]
])

for (let chave of assuntosMap.keys()) {
    console.log(chave)
}

for (let valor of assuntosMap.values()) {
    console.log(valor)
}

for (let [chave, valor] of assuntosMap.entries()) {
    console.log(chave, valor)
}

const strs = new Set(['a', 'b', 'c'])
for (let letra of strs) {
    console.log(letra)
}