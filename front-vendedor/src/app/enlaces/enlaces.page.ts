import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { iosTransitionAnimation } from '@ionic/angular';
import { ApiService } from 'src/services/products/products.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LinksService } from 'src/services/links/links.service';

@Component({
  selector: 'app-enlaces',
  templateUrl: './enlaces.page.html',
  styleUrls: ['./enlaces.page.scss'],
})
export class EnlacesPage implements OnInit {

  productosData: any;  // Aquí almacenaremos la respuesta del servicio
  enlacesData: any;
  id: any;
  nombreCuenta: any;
  saldoCuenta: any;
  numeroCuenta: any;
  mostrarSaldo: any;


  constructor(private location: Location,
    private apiService: ApiService,
    private route: ActivatedRoute,
    private linksService: LinksService,
    private router: Router) {
      this.id = this.route.snapshot.params['numerocuenta'];
     }

    ngOnInit() {
    const idUsuario = 2;  // Cambia esto según tu necesidad
    this.apiService.getProductos(idUsuario).subscribe(
      (data) => {
        this.productosData = data;  // Guardamos la respuesta en la variable productosData

        const cuentaEspecifica = this.productosData.productos.find((producto: any) => producto.numero_cuenta === this.id);

        if (cuentaEspecifica) {
          this.nombreCuenta = cuentaEspecifica.tipo_cuenta;
          this.saldoCuenta = cuentaEspecifica.saldo;
          this.numeroCuenta = cuentaEspecifica.numero_cuenta;

          console.log('Tipo de cuenta:', this.nombreCuenta);
          console.log('Saldo:', this.saldoCuenta);
        } else {
          console.log('No se encontró la cuenta con el número 9381112');
        }
      },
      (error) => {
        console.error('Error al obtener productos:', error);
      }
    );    

    const codigoProducto = this.id;

    this.linksService.obtenerDatosEnlacesPago(codigoProducto).subscribe(
      (data) => {
        this.enlacesData = data;
        console.log(this.enlacesData);
      },
      (error) => {
        console.error('Error al obtener datos:', error);
      }
    );
  }

  copiarAlPortapapeles(texto: string) {
    const elemento = document.createElement('textarea');
    elemento.value = texto;
    document.body.appendChild(elemento);
    elemento.select();
    document.execCommand('copy');
    document.body.removeChild(elemento);
  }
  

  obtenerTresPrimerasPalabras(nombreCuenta: string): string {
    if (!nombreCuenta) return '';  // Verifica si nombreCuenta es undefined o null
  
    const palabras = nombreCuenta.split(' ');
    return palabras.slice(0, 3).join(' ');
  }
  
  obtenerUltimos4Digitos(numeroCuenta: string): string {
    if (!numeroCuenta) return '';  // Verifica si numeroCuenta es undefined o null
  
    return numeroCuenta.slice(-4);
  }

  toggleMostrarSaldo() {
    this.mostrarSaldo = !this.mostrarSaldo;
  }

  goToQR(codigo: string, nombre: string) {
    this.router.navigate(['/qr', codigo, nombre]);  // Utiliza el número de cuenta como parte de la URL
  }
  
  volverAtras(): void {
    this.location.back();  // Navegar hacia atrás en el historial
  }

}
