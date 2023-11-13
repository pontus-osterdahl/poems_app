import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegBreakComponent } from './reg-break.component';

describe('RegBreakComponent', () => {
  let component: RegBreakComponent;
  let fixture: ComponentFixture<RegBreakComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegBreakComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegBreakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
