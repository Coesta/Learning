//
//  RefeicaoDao.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 05/03/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import Foundation

class RefeicaoDao {
    
    func save(_ refeicoes: [Refeicao]) {
        
        guard let caminho = recuperarCaminho() else { return }
        
        do {
            let dados = try NSKeyedArchiver.archivedData(withRootObject: refeicoes, requiringSecureCoding: false)
            try dados.write(to: caminho)
        } catch {
            print(error.localizedDescription)
        }
        
        print(caminho)
    }
    
    func recuperar() -> [Refeicao] {
        do  {
            guard let caminho = recuperarCaminho() else {
                return []
            }
            
            let dados = try Data(contentsOf: caminho)
            guard let refeicoesSalvas = try NSKeyedUnarchiver.unarchiveTopLevelObjectWithData(dados) as? Array<Refeicao> else { return [] }
            
            return refeicoesSalvas
            
        } catch {
            print(error.localizedDescription)
            return []
        }
    }
    
    func recuperarCaminho() -> URL? {
        guard let diretorio = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first else { return nil }
        
        let caminho = diretorio.appendingPathComponent("refeicao")
        
        return caminho
    }
}
