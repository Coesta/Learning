//
//  ViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 17/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

protocol AdicionaRefeicaoDelegate{
    func adicionarRefeicao(_ refeicao: Refeicao)
}

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate, AdicionaItemDelegate {
    
    // MARK: - IBOutlets
    
    @IBOutlet weak var itensTableView: UITableView?
    
    // MARK: - Atributos
    
    var delegate: AdicionaRefeicaoDelegate?
    
    var itens : [Item] = [Item(nome: "Molho de Tomate", calorias: 40.0),
                        Item(nome: "Molho de Limão", calorias: 40.0),
                        Item(nome: "Sal", calorias: 40.0),
                        Item(nome: "Molho de apimentado", calorias: 40.0),
                        Item(nome: "Leite Condensado", calorias: 40.0)]
    
    var itensSelecionados: [Item] = []
    
    // MARK: - IBOutlets
    
    @IBOutlet weak var nomeTextField: UITextField?
    @IBOutlet weak var felicidadeTextField: UITextField?
    
    // MARK: - View LifeCycle
    
    override func viewDidLoad() {
        let botaoAdicionarItem = UIBarButtonItem(title: "Adicionar", style: .plain, target: self, action: #selector(adicionarItem))
        
        navigationItem.rightBarButtonItem = botaoAdicionarItem
    }
    
    @objc func adicionarItem() {
        let addItemViewController = AdicionarItensViewController(delegate: self)
        
        navigationController?.pushViewController(addItemViewController, animated: true)
    }
    
    func add(_ item: Item) {
        itens.append(item)
        
        if let tableview = itensTableView {
            tableview.reloadData()
        } else {
            Alerta(controller: self).exibir()
        }
    }
    
    // MARK: - UITableViewDataSource
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return itens.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let celula = UITableViewCell(style: .default, reuseIdentifier: nil)
        let linhaDaTabela = indexPath.row
        let item = itens[linhaDaTabela]
        celula.textLabel?.text = item.nome
        return celula
    }
    
    // MARK: - UITableViewDelegate
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        guard let celula = tableView.cellForRow(at: indexPath) else { return }
        
        if celula.accessoryType == .none {
            celula.accessoryType = .checkmark
            
            let linhaDaTabela = indexPath.row
            itensSelecionados.append(itens[linhaDaTabela])
        } else {
            celula.accessoryType = .none
            
            let item  = itens[indexPath.row]
            if let position = itensSelecionados.firstIndex(of: item) {
                itensSelecionados.remove(at: position)
                
                // teste
                
                for item in itensSelecionados {
                    print(item.nome)
                }
                
            }
            
        }
    }
    
    // MARK: - IBActions
    
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
        
        let refeicao = Refeicao(nome: nomeDaRefeicao, felicidade: felicidade, itens: itensSelecionados)
        
        print("Refeição: \(refeicao.nome) ---- Felicidade: \(refeicao.felicidade)")
        
        delegate?.adicionarRefeicao(refeicao)
        navigationController?.popViewController(animated: true)
        
    }

}

