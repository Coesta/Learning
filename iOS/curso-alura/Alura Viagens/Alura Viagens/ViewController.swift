//
//  ViewController.swift
//  Alura Viagens
//
//  Created by Leonardo Costa on 09/03/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource {
    
    @IBOutlet weak var tabelaViagens: UITableView!
    
    let listaViagens: Array<String> = ["Rio de Janeiro", "Ceará", "São Paulo"]

    override func viewDidLoad() {
        super.viewDidLoad()
        self.tabelaViagens.dataSource = self
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return listaViagens.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        cell.textLabel?.text = listaViagens[indexPath.row]
        return cell
    }

}

