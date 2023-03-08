import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextPresentationComponent } from './text-presentation.component';

describe('TextPresentationComponent', () => {
  let component: TextPresentationComponent;
  let fixture: ComponentFixture<TextPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextPresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TextPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
