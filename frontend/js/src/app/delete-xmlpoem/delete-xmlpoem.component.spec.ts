import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteXmlpoemComponent } from './delete-xmlpoem.component';

describe('DeleteXmlpoemComponent', () => {
  let component: DeleteXmlpoemComponent;
  let fixture: ComponentFixture<DeleteXmlpoemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteXmlpoemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteXmlpoemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
