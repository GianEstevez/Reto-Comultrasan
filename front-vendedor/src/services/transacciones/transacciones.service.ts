import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransaccionesService {
  private apiUrl = 'http://127.0.0.1:8080/api/pagos/enlace';

  constructor(private http: HttpClient) { }

  obtenerInformacion(codigoEnlace: string): Observable<any> {
    const url = `${this.apiUrl}?codigoEnlace=${codigoEnlace}`;
    return this.http.get(url);
  }
}
