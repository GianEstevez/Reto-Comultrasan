import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import * as QRCode from 'qrcode';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-qr',
  templateUrl: './qr.page.html',
  styleUrls: ['./qr.page.scss'],
})
export class QrPage implements OnInit {

  qrCodeUrl: SafeUrl | null = null;
  enlaceNombreVar: any;


  constructor(private sanitizer: DomSanitizer,
    private location: Location,
    private route: ActivatedRoute) {
      this.enlaceNombreVar = this.route.snapshot.params['enlacenombre'];
     }

  ngOnInit() {
    this.generateQRCodeWithIcon();
  }
  
  generateQRCodeWithIcon(): void {
    const canvas = document.createElement('canvas');
    QRCode.toCanvas(canvas, 'https://www.google.com', { width: 200 }, (error) => {
      if (error) {
        console.error('Error al generar el código QR:', error);
        return;
      }

      // Convertir el canvas en una URL segura
      const url = canvas.toDataURL('image/png');
      this.qrCodeUrl = this.sanitizer.bypassSecurityTrustUrl(url);
    });
  }

  volverAtras(): void {
    this.location.back();  // Navegar hacia atrás en el historial
  }
  
}
