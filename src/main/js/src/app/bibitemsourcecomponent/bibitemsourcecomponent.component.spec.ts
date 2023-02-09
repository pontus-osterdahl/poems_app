import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BibitemsourcecomponentComponent } from './bibitemsourcecomponent.component';

describe('BibitemsourcecomponentComponent', () => {
  let component: BibitemsourcecomponentComponent;
  let fixture: ComponentFixture<BibitemsourcecomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BibitemsourcecomponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BibitemsourcecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
