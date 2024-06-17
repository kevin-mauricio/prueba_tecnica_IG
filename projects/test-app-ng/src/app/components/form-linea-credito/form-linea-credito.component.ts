import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-form-linea-credito',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
  ],
  templateUrl: './form-linea-credito.component.html',
  styleUrl: './form-linea-credito.component.css'
})
export class FormLineaCreditoComponent {
  formLineaCredito: FormGroup;
  @Output() lineaCredito: EventEmitter<any> = new EventEmitter<any>();

  constructor(private fb: FormBuilder) {
    this.formLineaCredito = this.fb.group({
      valorMinimo: [],
      valorMaximo: [],
      plazoMaximo: []
    });
  }

  sendLineaCredito() {
    this.lineaCredito.emit(this.formLineaCredito.value);
    this.formLineaCredito.reset();
  }
}
