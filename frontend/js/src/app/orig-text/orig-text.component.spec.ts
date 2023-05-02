import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrigTextComponent } from './orig-text.component';

describe('OrigTextComponent', () => {
  let component: OrigTextComponent;
  let fixture: ComponentFixture<OrigTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrigTextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrigTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
