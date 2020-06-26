import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroesFromFirebaseComponent } from './heroes-from-firebase.component';

describe('HeroesFromFirebaseComponent', () => {
  let component: HeroesFromFirebaseComponent;
  let fixture: ComponentFixture<HeroesFromFirebaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeroesFromFirebaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeroesFromFirebaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
