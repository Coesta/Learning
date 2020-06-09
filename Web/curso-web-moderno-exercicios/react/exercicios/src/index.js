import React from 'react'
import ReactDOM from 'react-dom'

// import BomDia from './components/BomDia'
// import Multi, { BoaNoite } from './components/Multiplos'
// import Saudacao from './components/Saudacao'
import Pai from './components/Pai'
import Filho from './components/Filho'

ReactDOM.render(
    // <div>
    //     <BomDia nome="Leonardo" />
    //     <Multi.BoaTarde nome="Beatriz" />
    //     <BoaNoite nome="Gabriela" />
    // </div>
    // <div>
    //     <Saudacao tipo="Bom dia" nome="João"/>
    // </div>
    <div>
        <Pai nome="Paulo" sobrenome="Silva">
            <Filho nome="Pedro"/>
            <Filho nome="José"/>
            <Filho nome="Carla"/>
        </Pai>
    </div>
    , document.getElementById('root'))
