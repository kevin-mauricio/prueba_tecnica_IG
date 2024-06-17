import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLineaCreditoComponent } from './form-linea-credito.component';

describe('FormLineaCreditoComponent', () => {
  let component: FormLineaCreditoComponent;
  let fixture: ComponentFixture<FormLineaCreditoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormLineaCreditoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormLineaCreditoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
