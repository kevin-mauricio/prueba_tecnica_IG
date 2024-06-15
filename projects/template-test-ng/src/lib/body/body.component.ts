import { Component, Input } from '@angular/core';

@Component({
  selector: 'lib-body',
  standalone: true,
  imports: [],
  templateUrl: './body.component.html',
  styleUrl: './body.component.css'
})
export class BodyComponent {
  @Input() clientes: any[] = [];
}
