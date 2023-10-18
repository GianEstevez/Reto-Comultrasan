import { Component } from '@angular/core';
import { ApiService } from 'src/services/products/products.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  productosData: any;  // Aquí almacenaremos la respuesta del servicio
  mostrarSaldo: { [key: number]: boolean } = {};
  mostrarUltimos4Digitos: boolean[] = []; // Array para mantener el estado de cada producto
  mostrarCuenta: any;


  constructor(private apiService: ApiService,
    private router: Router) { }

  ngOnInit() {
    const idUsuario = 2;  // Cambia esto según tu necesidad
    this.apiService.getProductos(idUsuario).subscribe(
      (data) => {
        this.productosData = data;  // Guardamos la respuesta en la variable productosData
        console.log(this.productosData);  // Imprime la respuesta aquí
      },
      (error) => {
        console.error('Error al obtener productos:', error);
      }
    );
    
  }
  
  toggleMostrarSaldo(index: number) {
    this.mostrarSaldo[index] = !this.mostrarSaldo[index];
  }

  goToProduct(cuenta: string) {
    this.router.navigate(['/enlaces', cuenta]);  // Utiliza el número de cuenta como parte de la URL
  }

  toggleMostrarUltimos4Digitos(index: number) {
    this.mostrarUltimos4Digitos[index] = !this.mostrarUltimos4Digitos[index];
  }

  toggleMostrarCuenta() {
    this.mostrarCuenta = !this.mostrarCuenta;
  }

  getProductos() {

  }

}
