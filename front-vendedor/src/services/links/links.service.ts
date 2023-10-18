import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LinksService {

  private apiUrl = 'http://127.0.0.1:8080/api/productos/enlacesPago';

  constructor(private http: HttpClient) { }

  obtenerDatosEnlacesPago(codigoProducto: string): Observable<any> {
    const url = `${this.apiUrl}?codigoProducto=${codigoProducto}`;
    return this.http.get(url);
  }
}
