import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from '../../../template-test-ng/src/lib/header/header.component';
import { MenuComponent } from '../../../template-test-ng/src/lib/menu/menu.component';
import { BodyComponent } from '../../../template-test-ng/src/lib/body/body.component';
import { FooterComponent } from '../../../template-test-ng/src/lib/footer/footer.component';
import { ClienteService } from './services/cliente.service';
import { Cliente } from './models/cliente';
import { LineaCreditoService } from './services/lineacredito.service';
import { LineaCredito } from './models/LineaCredito';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    HeaderComponent,
    MenuComponent,
    BodyComponent,
    FooterComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'test-app-ng';

  clientes: Cliente[] = [];
  lineaCredito: LineaCredito = {};

  lineaCreditoForm = new FormGroup({
    valor_maximo: new FormControl(),
    valor_minimo: new FormControl(),
    plazo_maximo: new FormControl(),
  });
  
  constructor(
    private clienteService: ClienteService,
    private lineaCreditoService: LineaCreditoService
  ) {

  }

  ngOnInit(): void {
    this.getAllClientes();
  }

  getAllClientes() {
    this.clienteService.getAllClientes().subscribe( data =>{
      this.clientes = data;
      console.log(data);
    });
  }

}
