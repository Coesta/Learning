//
//  ItemDao.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 05/03/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import Foundation

class ItemDao {
    
    func save(_ itens: [Item]) {
        do {
            let dados = try NSKeyedArchiver.archivedData(withRootObject: itens, requiringSecureCoding: false)
            guard let caminho = recuperarDiretorio() else { return }
            try dados.write(to: caminho)
        } catch {
            print(error.localizedDescription)
        }
    }
    
    func recuperar() -> [Item] {
        guard let diretorio = recuperarDiretorio() else { return [] }
        
        do {
            let dados = try Data(contentsOf: diretorio)
            let itensSalvos = try NSKeyedUnarchiver.unarchiveTopLevelObjectWithData(dados) as! Array<Item>
            return itensSalvos
        } catch {
            print(error.localizedDescription)
            return []
        }
        
    }
    
    func recuperarDiretorio() -> URL? {
        guard let diretorio = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first else { return nil }
        
        let caminho = diretorio.appendingPathComponent("itens")
        
        return caminho
    }
    
    
}
