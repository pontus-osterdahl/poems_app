import { ComponentFixture, TestBed } from '@angular/core/testing';

import { XmlpoemComponent } from './xmlpoem.component';

describe('XmlpoemComponent', () => {
  let component: XmlpoemComponent;
  let fixture: ComponentFixture<XmlpoemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ XmlpoemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(XmlpoemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
