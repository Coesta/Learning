//
//  RefeicoesTableViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 19/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class RefeicoesTableViewController: UITableViewController, ViewControllerDelegate {
    
    var refeicoes = [Refeicao(nome: "Pizza", felicidade: 5),
                     Refeicao(nome: "Lasanha", felicidade: 5),
                     Refeicao(nome: "Pamonha", felicidade: 3)]
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return refeicoes.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let celula = UITableViewCell(style: .default, reuseIdentifier: nil)
        let refeicao = refeicoes[indexPath.row]
        celula.textLabel?.text = refeicao.nome
        
        return celula
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "adicionarRefeicao" {
            if let viewController = segue.destination as? ViewController {
                viewController.delegate = self
            }
        }
        
    }
    
    func adicionarRefeicao(_ refeicao: Refeicao){
        refeicoes.append(refeicao)
        tableView.reloadData()
    }
}
