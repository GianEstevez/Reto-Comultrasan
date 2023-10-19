import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlantillaService } from '../services/plantilla.service';
@Component({
  selector: 'app-transaccion',
  templateUrl: './transaccion.page.html',
  styleUrls: ['./transaccion.page.scss'],
})
export class TransaccionPage implements OnInit {

  codigoParam: any;

  constructor(private router: Router,
    private route: ActivatedRoute) {
      this.codigoParam = this.route.snapshot.params['codigo'];
   }

  irAImprimirComprobante() {
    // Redirigir a la página de comprobante-pago.html
    this.router.navigate(['/comprobante-pago/'+this.codigoParam]);
  }

  ngOnInit() {
  }

}