//
//  Item.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 18/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class Item: NSObject {
    let nome: String
    let calorias: Double
    
    init(nome: String, calorias: Double) {
        self.nome = nome
        self.calorias = calorias
    }
}
