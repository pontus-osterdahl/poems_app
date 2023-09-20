import { ComponentFixture, TestBed } from '@angular/core/testing';

import { XmlpoemsearchComponent } from './xmlpoemsearch.component';

describe('XmlpoemsearchComponent', () => {
  let component: XmlpoemsearchComponent;
  let fixture: ComponentFixture<XmlpoemsearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ XmlpoemsearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(XmlpoemsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
