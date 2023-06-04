import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentItemComponentWrapperComponent } from './content-item-component-wrapper.component';

describe('ContentItemComponentWrapperComponent', () => {
  let component: ContentItemComponentWrapperComponent;
  let fixture: ComponentFixture<ContentItemComponentWrapperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContentItemComponentWrapperComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContentItemComponentWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
