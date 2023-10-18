import { Component, OnInit } from '@angular/core';
import { mockCampos } from '../mocks/mockCampos';

@Component({
  selector: 'app-pasarela-pagos',
  templateUrl: './pasarela-pagos.page.html',
  styleUrls: ['./pasarela-pagos.page.scss'],
})
export class PasarelaPagosPage implements OnInit {
  mockCampos = mockCampos;
  negocioData: any = mockCampos.plantilla;
  compradorData: any = mockCampos.comprador;
  

  constructor() { }

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

}
