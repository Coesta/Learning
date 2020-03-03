//
//  RemoveRefeicaoViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 02/03/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class RemoveRefeicaoViewController {
    
    let controller: UIViewController
    
    init(controller: UIViewController) {
        self.controller = controller
    }
    
    func exibir(_ refeicao: Refeicao, handler: @escaping (UIAlertAction) -> Void){
        let alerta = UIAlertController(title: refeicao.nome, message: refeicao.detalhes(),
            preferredStyle: .alert)
        
        let botaoFechar = UIAlertAction(title: "Fechar", style: .cancel)
        alerta.addAction(botaoFechar)
        
        let botaoRemover = UIAlertAction(
            title: "Remover",
            style: .destructive,
            handler: handler)
        alerta.addAction(botaoRemover)
        
        controller.present(alerta, animated: true, completion: nil)
    }
}
