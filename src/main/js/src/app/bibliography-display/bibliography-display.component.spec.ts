import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BibliographyDisplayComponent } from './bibliography-display.component';

describe('BibliographyDisplayComponent', () => {
  let component: BibliographyDisplayComponent;
  let fixture: ComponentFixture<BibliographyDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BibliographyDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BibliographyDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
