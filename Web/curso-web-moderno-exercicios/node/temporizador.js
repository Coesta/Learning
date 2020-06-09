const schedule = require('node-schedule')

/**
 * tarefa que é executada a cada 5 segundos 
 * a partir das 19 horas 
 * de toda sexta-feira
 * */
const tarefa1 = schedule.scheduleJob('*/5 * 19 * * 5', () => {
    console.log('Executando Tarefa 1!', new Date().getSeconds())
})

setTimeout(function () {
    tarefa1.cancel()
    console.log('Cancelando Tarefa 1!')
}, 10000)

// setImmediate
// setInterval

const regra = new schedule.RecurrenceRule()
regra.dayOfWeek = [new schedule.Range(1, 5)]
regra.hour = 19
regra.second = 30

const tarefa2 = schedule.scheduleJob(regra, function () {
    console.log('Executando Tarefa 2!', new Date().getSeconds())
})