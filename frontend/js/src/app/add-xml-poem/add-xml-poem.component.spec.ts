import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddXmlPoemComponent } from './add-xml-poem.component';

describe('AddXmlPoemComponent', () => {
  let component: AddXmlPoemComponent;
  let fixture: ComponentFixture<AddXmlPoemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddXmlPoemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddXmlPoemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
