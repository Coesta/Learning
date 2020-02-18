//
//  Refeicao.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 18/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class Refeicao: NSObject {
    
    let nome: String
    let felicidade: Int
    let itens: Array<Item> = []
    
    init(nome: String, felicidade: Int) {
        self.nome = nome
        self.felicidade = felicidade
    }

    func obterTotalCalorias() -> Double {
        var total = 0.0
        
        for item in itens {
            total += item.calorias
        }
        
        return total
    }
    
}
