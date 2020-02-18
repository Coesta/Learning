//
//  ViewController.swift
//  tabela-dinamica-refeicoes
//
//  Created by Leonardo Costa on 18/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {

    let refeicoes = ["Churros", "Pizza", "Lasanha"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    // número de linhas
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return refeicoes.count
    }

    // conteúdo
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let celula = UITableViewCell(style: .default, reuseIdentifier: nil)
        
        let refeicao = refeicoes[indexPath.row]
        celula.textLabel?.text = refeicao
        
        return celula
    }
}

