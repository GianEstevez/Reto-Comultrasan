import { Component, OnInit } from '@angular/core';
import { mockCampos } from 'src/app/mocks/mockCampos'
import { Router } from '@angular/router';

@Component({
  selector: 'app-pasarela-pagos',
  templateUrl: './pasarela-pagos.page.html',
  styleUrls: ['./pasarela-pagos.page.scss'],
})
export class PasarelaPagosPage implements OnInit {
  mockCampos = mockCampos;
  negocioData: any = mockCampos.plantilla;
  compradorData: any = mockCampos.comprador;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    // Aquí puedes enviar this.formData al backend
    console.log(this.negocioData);
  }

  onSubmitComprador() {
    // Lógica para enviar los datos del comprador
    console.log(this.compradorData);
  }

  procesarPago(tipo: string) {
    if (tipo === 'PSE') {
      // Redirigir a la página web deseada
      const enlaceExterno = 'https://registro.pse.com.co/PSEUserRegister/';
      window.open(enlaceExterno, '_blank');
  
      // Después de 10 segundos, redirigir a otra página en la aplicación
      setTimeout(() => {
        this.router.navigate(['/transaccion']);
      }, 3000); // 10 segundos en milisegundos
    } else if (tipo === 'FC') {
      // Realizar la redirección para 'FC' de manera similar
      const enlaceExterno = 'https://www.financieracomultrasan.com.co/es/personas/productos-y-servicios/convenios-y-alianzas/pagos-pse-convenio?language=en';
      window.open(enlaceExterno, '_blank');
  
      // Después de 10 segundos, redirigir a otra página en la aplicación
      setTimeout(() => {
        this.router.navigate(['/transaccion']);
      }, 3000); // 10 segundos en milisegundos
    }
  }
  

}