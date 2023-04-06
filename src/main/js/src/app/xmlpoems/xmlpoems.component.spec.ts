import { ComponentFixture, TestBed } from '@angular/core/testing';

import { XmlpoemsComponent } from './xmlpoems.component';

describe('XmlpoemsComponent', () => {
  let component: XmlpoemsComponent;
  let fixture: ComponentFixture<XmlpoemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ XmlpoemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(XmlpoemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
