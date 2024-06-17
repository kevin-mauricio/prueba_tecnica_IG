import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListLineasCreditoComponent } from './list-lineas-credito.component';

describe('ListLineasCreditoComponent', () => {
  let component: ListLineasCreditoComponent;
  let fixture: ComponentFixture<ListLineasCreditoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListLineasCreditoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListLineasCreditoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
