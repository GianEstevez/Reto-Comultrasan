import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlantillaService } from '../services/plantilla.service';

@Component({
  selector: 'app-comprobante-pago',
  templateUrl: './comprobante-pago.page.html',
  styleUrls: ['./comprobante-pago.page.scss'],
})
export class ComprobantePagoPage implements OnInit {
  codigoParam: any;
  productosData: any;
  valor: any;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private plantillaService: PlantillaService) { 
    this.codigoParam = this.route.snapshot.params['codigo'];
  }

  ngOnInit() {
    this.plantillaService.getPlantilla(this.codigoParam).subscribe(
      (data) => {
        this.productosData = data;  // Guardamos la respuesta en la variable productosData
        this.valor = this.productosData.valor;
        console.log(this.productosData);  // Imprime la respuesta aquí
      },
      (error) => {
        console.error('Error al obtener productos:', error);
      }
    );
  }

}
