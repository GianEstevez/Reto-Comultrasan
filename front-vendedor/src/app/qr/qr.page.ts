import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import * as QRCode from 'qrcode';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { TransaccionesService } from 'src/services/transacciones/transacciones.service';

@Component({
  selector: 'app-qr',
  templateUrl: './qr.page.html',
  styleUrls: ['./qr.page.scss'],
})
export class QrPage implements OnInit {

  qrCodeUrl: SafeUrl | null = null;
  enlaceNombreVar: any;
  codigoEnlace: any;
  urlQR: any;
  transaccionesData: any;


  constructor(private sanitizer: DomSanitizer,
    private location: Location,
    private route: ActivatedRoute,
    private toastController: ToastController,
    private transaccionesService: TransaccionesService) {
      this.enlaceNombreVar = this.route.snapshot.params['enlacenombre'];
      this.codigoEnlace = this.route.snapshot.params['codigoenlace'];

     }

  ngOnInit() {
    this.generateQRCodeWithIcon();

    this.transaccionesService.obtenerInformacion(this.codigoEnlace).subscribe(data => {
      this.transaccionesData = data;
      console.log(this.transaccionesData);
    });

  }



  
  generateQRCodeWithIcon(): void {
    this.urlQR = 'http://localhost:8100/pago/' + this.codigoEnlace;
    const canvas = document.createElement('canvas');
    QRCode.toCanvas(canvas, this.urlQR, { width: 200 }, (error) => {
      if (error) {
        console.error('Error al generar el código QR:', error);
        return;
      }

      // Convertir el canvas en una URL segura
      const url = canvas.toDataURL('image/png');
      this.qrCodeUrl = this.sanitizer.bypassSecurityTrustUrl(url);
    });
  }

  copiarAlPortapapeles(texto: string) {
    const elemento = document.createElement('textarea');
    elemento.value = texto;
    document.body.appendChild(elemento);
    elemento.select();
    document.execCommand('copy');
    document.body.removeChild(elemento);
    this.mostrarSnackbar();
  }

  async mostrarSnackbar() {
    const toast = await this.toastController.create({
      message: 'Enlace de pago copiado al portapapeles!',
      duration: 2000, // Duración en milisegundos
      position: 'bottom', // Posición del Snackbar
      color: 'dark' // Color del Snackbar
    });
    toast.present();
  }

  volverAtras(): void {
    this.location.back();  // Navegar hacia atrás en el historial
  }
  
}
