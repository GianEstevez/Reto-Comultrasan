import { Component, OnInit } from '@angular/core';
import { mockCampos } from 'src/app/mocks/mockCampos'
import { ActivatedRoute, Router } from '@angular/router';
import { PlantillaService } from '../services/plantilla.service';
@Component({
  selector: 'app-pago',
  templateUrl: './pago.page.html',
  styleUrls: ['./pago.page.scss'],
})
export class PagoPage implements OnInit {
  mockCampos = mockCampos;
  negocioData: any;
  compradorData: any;
  codigoParam: any;
  productosData: any;
  fingerprintData: string = '';

  constructor(private router: Router,
    private route: ActivatedRoute,
    private plantillaService: PlantillaService) {
      this.codigoParam = this.route.snapshot.params['codigo'];
   }

  ngOnInit() {
    this.plantillaService.getPlantilla(this.codigoParam).subscribe(
      (data) => {
        this.productosData = data;  // Guardamos la respuesta en la variable productosData
        this.negocioData = this.productosData.plantilla;
        this.compradorData = this.productosData.comprador;
        console.log(this.productosData);  // Imprime la respuesta aquí
      },
      (error) => {
        console.error('Error al obtener productos:', error);
      }
    );
    const fechaHora = new Date();
    console.log('Fecha y hora del llenado del formulario:', fechaHora);

    const tipoDispositivo = navigator.userAgent;
    console.log('Tipo de dispositivo:', tipoDispositivo);

    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition( (position) => {
        const latitud = position.coords.latitude;
        const longitud = position.coords.longitude;
        console.log('Ubicación actual (latitud, longitud):', latitud, longitud);

        // Enviar datos al backend
        this.enviarDatosAlBackend(fechaHora, tipoDispositivo, latitud, longitud);
      });
    } else {
      console.log('El navegador no admite la geolocalización.');
    }

  }

  enviarDatosAlBackend(fechaHora: any, tipoDispositivo: any, latitud: any, longitud: any) {
    // Definir la URL del backend
    const url = 'https://tu-servidor-backend.com/tu-endpoint';

    // Datos a enviar al backend
    const fingerprint = { fechaHora,
      tipoDispositivo,
      latitud,
      longitud,
    };

    // Realiza una solicitud POST al servidor con los datos
    //this.http.post(url, fingerprint).subscribe(
    //  (respuesta) => {
    //    console.log('Datos enviados al backend:', respuesta);
    //  },
    //  (error) => {
    //    console.error('Error al enviar datos al backend:', error);
    //  }
    //);
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

