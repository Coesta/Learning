import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';

@Component({
  selector: 'app-heroes-from-firebase',
  templateUrl: './heroes-from-firebase.component.html',
  styleUrls: ['./heroes-from-firebase.component.css']
})
export class HeroesFromFirebaseComponent implements OnInit {
  
  heroes:Observable<any[]>

  constructor(private firestore: AngularFirestore) { }

  ngOnInit(): void {
    this.heroes = this.firestore.collection('heroes').valueChanges()
  }

}
