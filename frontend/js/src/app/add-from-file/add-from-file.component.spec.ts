import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFromFileComponent } from './add-from-file.component';

describe('AddFromFileComponent', () => {
  let component: AddFromFileComponent;
  let fixture: ComponentFixture<AddFromFileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFromFileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFromFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
