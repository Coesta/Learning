//
//  Alerta.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 02/03/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class Alerta {
    
    let controller : UIViewController
    
    init(controller: UIViewController) {
        self.controller = controller
    }
    
    func exibir(titulo: String = "Atenção", mensagem: String) {
        let alerta = UIAlertController(title: titulo, message: mensagem, preferredStyle: .alert)
        let fecharBotao = UIAlertAction(title: "Fechar", style: .cancel, handler: nil)
        
        alerta.addAction(fecharBotao)
        controller.present(alerta, animated: true, completion: nil)
    }
}
