import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LineaCredito } from '../models/LineaCredito';

@Injectable({
  providedIn: 'root'
})
  export class LineaCreditoService {

  private apiUrl = 'http://localhost:8080/api/lineas-credito';

  constructor(private http: HttpClient) { }

  public createLineaCredito(lineaCredito: LineaCredito): Observable<LineaCredito> {
    return this.http.post<LineaCredito>(this.apiUrl, lineaCredito);
  }
}
