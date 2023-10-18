
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  inputs: { label: string; name: string; value: string }[] = [];
  procesarPago(arg0: string) {
throw new Error('Method not implemented.');
}
  monto: number | undefined;
  descripcion: string | undefined;
  idComprador: string | undefined;

  constructor() {
    this.addInput();
      // Agrega el primer campo de entrada por defecto

  }

  addInput() {
    // Agrega un nuevo campo de entrada a la lista
    this.inputs.push({ label: 'Nuevo Campo', name: `field${this.inputs.length}`, value: '' });
  }

  submitForm() {
    // Aquí puedes procesar los valores de los campos de entrada
    for (const input of this.inputs) {
      console.log(`Campo ${input.label}: ${input.value}`);
      // Aquí puedes realizar acciones adicionales, como enviar los datos a un servidor
    }
  }
    // Aquí puedes agregar la lógica para procesar el pago según la opción (PSE o FC)
    // Puedes acceder a los valores de los campos de entrada: this.monto, this.descripcion, this.idComprador
  }
