import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PlantillaService {

  private baseUrl = 'http://127.0.0.1:8080/api';

  constructor(private http: HttpClient) { }

  getPlantilla(idUsuario: number): Observable<any> {
    const url = `${this.baseUrl}/pagos?codigo=${idUsuario}`;
    return this.http.get(url);
  }
}
