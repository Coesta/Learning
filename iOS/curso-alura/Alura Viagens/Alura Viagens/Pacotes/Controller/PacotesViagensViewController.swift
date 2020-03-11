//
//  PacotesViagensViewController.swift
//  Alura Viagens
//
//  Created by Leonardo Costa on 11/03/20.
//  Copyright © 2020 Leonardo Costa. All rights reserved.
//

import UIKit

class PacotesViagensViewController: UIViewController, UICollectionViewDataSource {

    @IBOutlet weak var colecaoPacotesViagem: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        colecaoPacotesViagem.dataSource = self
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 5
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "celulaPacote", for: indexPath) as! PacoteViagemCollectionViewCell
        cell.backgroundColor = UIColor.blue
        
        return cell
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
