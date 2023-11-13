import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrigBreakComponent } from './orig-break.component';

describe('OrigBreakComponent', () => {
  let component: OrigBreakComponent;
  let fixture: ComponentFixture<OrigBreakComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrigBreakComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrigBreakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
