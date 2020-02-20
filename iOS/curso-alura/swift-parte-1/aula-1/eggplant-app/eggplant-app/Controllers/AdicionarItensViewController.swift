//
//  AdicionarItensViewController.swift
//  eggplant-app
//
//  Created by Leonardo Costa on 20/02/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class AdicionarItensViewController: UIViewController {
    
    // MARK: - View lifecycle

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // MARK: - IBAction
    
    @IBAction func adicionarItem(_ sender: Any) {
        navigationController?.popViewController(animated: true)
    }
    
}
