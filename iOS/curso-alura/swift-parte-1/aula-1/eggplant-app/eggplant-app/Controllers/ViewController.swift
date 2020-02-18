//
//  ViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 17/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var nomeTextField: UITextField?
    
    @IBOutlet weak var felicidadeTextField: UITextField?
    
    @IBAction func adicionar(_ sender: Any) {
        
        // Modo 1
        
//        if let nomeRefeicao = nomeTextField?.text, let felicidadeRefeicao = felicidadeTextField?.text {
//
//            if let felicidade = Int(felicidadeRefeicao) {
//                let refeicao = Refeicao(nome: nomeRefeicao, felicidade: felicidade)
//
//                print("Refeição: \(refeicao.nome) ---- Felicidade: \(refeicao.felicidade)")
//            } else {
//                print("Erro ao cadastrar refeição")
//            }
//        }
        
        // Modo 2
        
        guard let nomeDaRefeicao = nomeTextField?.text else {
            return
        }
        
        guard
            let felicidadeDaRefeicao = felicidadeTextField?.text,
            let felicidade = Int(felicidadeDaRefeicao)
            else {
            return
        }
        
        let refeicao2 = Refeicao(nome: nomeDaRefeicao, felicidade: felicidade)
        print("Refeição: \(refeicao2.nome) ---- Felicidade: \(refeicao2.felicidade)")
        
    }
    


}

