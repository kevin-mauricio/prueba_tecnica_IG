import { Component, Input } from '@angular/core';
import { LineaCredito } from '../../models/LineaCredito';

@Component({
  selector: 'app-list-lineas-credito',
  standalone: true,
  imports: [],
  templateUrl: './list-lineas-credito.component.html',
  styleUrl: './list-lineas-credito.component.css'
})
export class ListLineasCreditoComponent {
  @Input() lineasCredito: LineaCredito[] = []

}
