export const mockCampos = {
    vendedor: {
        nombre: 'Laura', 
        nroCuenta: '*****6'
    },
    comprador: [
        {nombre: 'Nombre', contenido: 'Amigo', regex: '[a-z]'},
        {nombre: 'Cedula', contenido: '3215', regex: '[0-9]'},
        {nombre: 'Contacto', contenido: '3125236451', regex: '[0-9]'},
        {nombre: 'Correo', contenido: '', regex: '^[a-zA-Z0-9. _%+-]+@[a-zA-Z0-9. -]+\\. [a-zA-Z]{2,}$'},
    ],
    valor: 12000,
    plantilla: [
        {nombre: 'Negocio', contenido: 'Arepas-san', regex: '[a-z]'},
        {nombre: 'Contacto', contenido: '3215', regex: '[0-9]'},
        {nombre: 'Descripción del Pago', contenido: 'pagué dos postres', regex: '[a-z]'},
    ],
}