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
import { FormLineaCreditoComponent } from './components/form-linea-credito/form-linea-credito.component';
import { ListLineasCreditoComponent } from './components/list-lineas-credito/list-lineas-credito.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    HeaderComponent,
    MenuComponent,
    BodyComponent,
    FooterComponent,
    FormLineaCreditoComponent,
    ListLineasCreditoComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'test-app-ng';

  clientes: Cliente[] = [];
  lineaCredito$!: LineaCredito;
  lineasCredito: LineaCredito[] = [];
  
  constructor(
    private clienteService: ClienteService,
    private lineaCreditoService: LineaCreditoService
  ) {

  }

  ngOnInit(): void {
    this.getAllClientes();
    this.getLineasCredito();
  }

  handleFormLineaCredito(lineaCredito: LineaCredito) {
    this.lineaCredito$ = lineaCredito;
    this.postLineaCredito();
  }

  getAllClientes() {
    this.clienteService.getAllClientes().subscribe( data =>{
      this.clientes = data;
      console.log(data);
    });
  }

  getLineasCredito(): void {
    this.lineaCreditoService.getLineasCredito().subscribe( data => {
      this.lineasCredito = data;
      console.log(data);
    });
  }

  postLineaCredito() {
    this.lineaCreditoService.createLineaCredito(this.lineaCredito$).subscribe( response => {
      console.log("status ok -> " + response);
    }

    );
  }

}
