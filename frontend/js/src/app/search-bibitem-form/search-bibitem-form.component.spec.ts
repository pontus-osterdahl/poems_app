import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBibitemFormComponent } from './search-bibitem-form.component';

describe('SearchBibitemFormComponent', () => {
  let component: SearchBibitemFormComponent;
  let fixture: ComponentFixture<SearchBibitemFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBibitemFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchBibitemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
