//
//  ViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 17/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var nomeTextField: UITextField!
    
    @IBOutlet weak var felicidadeTextField: UITextField!
    
    @IBAction func adicionar(_ sender: Any) {
        
        let nome = nomeTextField.text
        let felicidade = felicidadeTextField.text
        
        print("Refeição: \(nome) ---- Felicidade: \(felicidade)")
        
    }
    


}

