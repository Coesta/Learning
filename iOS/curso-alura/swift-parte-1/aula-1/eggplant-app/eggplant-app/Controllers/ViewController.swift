//
//  ViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 17/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

protocol ViewControllerDelegate{
    func adicionarRefeicao(_ refeicao: Refeicao)
}

class ViewController: UIViewController {
    
    var delegate: ViewControllerDelegate?
    
    @IBOutlet weak var nomeTextField: UITextField?
    @IBOutlet weak var felicidadeTextField: UITextField?
    
    @IBAction func adicionar(_ sender: Any) {
        
        guard let nomeDaRefeicao = nomeTextField?.text else {
            return
        }
        
        guard
            let felicidadeDaRefeicao = felicidadeTextField?.text,
            let felicidade = Int(felicidadeDaRefeicao)
            else {
            return
        }
        
        let refeicao = Refeicao(nome: nomeDaRefeicao, felicidade: felicidade)
        print("Refeição: \(refeicao.nome) ---- Felicidade: \(refeicao.felicidade)")
        
        delegate?.adicionarRefeicao(refeicao)
        navigationController?.popViewController(animated: true)
        
    }

}

