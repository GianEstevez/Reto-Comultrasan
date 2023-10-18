import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transaccion',
  templateUrl: './transaccion.page.html',
  styleUrls: ['./transaccion.page.scss'],
})
export class TransaccionPage implements OnInit {

  esTransaccionExitosa: boolean;

  constructor(private router: Router) {
    // Generar un número aleatorio (0 o 1)
    const numeroAleatorio = Math.floor(Math.random() * 2);

    // Determinar el resultado de la transacción basado en el número aleatorio
    this.esTransaccionExitosa = numeroAleatorio === 0;
  }

  irAImprimirComprobante() {
    // Redirigir a la página de comprobante-pago.html
    this.router.navigate(['/comprobante-pago']);
  }

  ngOnInit() {
  }

}