import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BibitemComponent } from './bibitem.component';

describe('BibitemComponent', () => {
  let component: BibitemComponent;
  let fixture: ComponentFixture<BibitemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BibitemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BibitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
