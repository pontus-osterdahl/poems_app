import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeiheaderComponent } from './teiheader.component';

describe('TeiheaderComponent', () => {
  let component: TeiheaderComponent;
  let fixture: ComponentFixture<TeiheaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeiheaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TeiheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
