//
//  AdicionarItensViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 20/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

protocol AdicionaItemDelegate {
    func add(_ item: Item)
}

class AdicionarItensViewController: UIViewController {
    
    // MARK: - IBOutlets
    
    @IBOutlet weak var nomeTextField: UITextField!
    @IBOutlet weak var caloriasTextField: UITextField!
    
    // MARK: - Delegates
    
    var delegate: AdicionaItemDelegate?
    
    init(delegate: AdicionaItemDelegate) {
        super.init(nibName: "AdicionarItensViewController", bundle: nil)
        self.delegate = delegate
    }
    
    required init?(coder aCoder: NSCoder) {
        super.init(coder: aCoder)
    }
    
    // MARK: - View lifecycle

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // MARK: - IBAction
    
    @IBAction func adicionarItem(_ sender: Any) {
        
        guard
            let nome = nomeTextField.text,
            let calorias = caloriasTextField.text
            else { return }
        
        guard let numeroCalorias = Double(calorias) else { return }
        
        let item = Item(nome: nome, calorias: numeroCalorias)
        delegate?.add(item)
        navigationController?.popViewController(animated: true)
    }
    
}
