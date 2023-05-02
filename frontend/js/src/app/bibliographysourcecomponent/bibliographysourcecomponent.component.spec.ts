import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BibliographysourcecomponentComponent } from './bibliographysourcecomponent.component';

describe('BibliographysourcecomponentComponent', () => {
  let component: BibliographysourcecomponentComponent;
  let fixture: ComponentFixture<BibliographysourcecomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BibliographysourcecomponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BibliographysourcecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
