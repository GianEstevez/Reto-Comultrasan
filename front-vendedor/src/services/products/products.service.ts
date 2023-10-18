import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl = 'http://127.0.0.1:8080/api';

  constructor(private http: HttpClient) { }

  getProductos(idUsuario: number): Observable<any> {
    const url = `${this.baseUrl}/productos?idUsuario=${idUsuario}`;
    return this.http.get(url);
  }
}
