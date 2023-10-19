# Reto Comultrasan - Equipo SUS

# Requerimientos

## Funcionales

### Generales
- La solución debe permitir la creación de códigos de pago (QRs y/o links de pago) por parte de usuarios autorizados, con un límite en la cantidad de códigos simultaneos activos.
- Los usuarios deben poder consultar su información de cuenta como saldo y número de cuenta.

### Códigos de pago
- Los usuarios deben poder personalizar los códigos de pago con datos por defecto como monto a pagar, descripción e identificación del pagador.
- Los códigos de pago deben ser fáciles de compartir y se debe proporcionar un enlace corto.
- Se debe permitir a los usuarios personalizar la interfaz de sus códigos de pago con una imagen o logo.
- Los códigos de pago deben ser generados con información relevante como fecha y hora de generación.
- Se debe proporcionar acceso a los usuarios para administrar sus códigos de pago y ver la información de pagos realizados por sus clientes o asociados.
- Los usuarios deben poder seleccionar entre diferentes tipos de formularios para cada código de pago, previamente definidos por la entidad.
- Los administradores deben ser capaces de limitar la cantidad de códigos simultaneos activos por usuario.
- Los administradores deben ser capaces de asignar o remover la capacidad de generar códigos de pago por cada usuario.

## No Funcionales

### UI
- La interfaz debe ser agradable, sencilla e intuitiva.

### Otros
- La solución debe ser capaz de registrar la información de pagos realizados, inluyendo la dirección IP, fecha y hora, y fingerprint del pagador.
- La solución debe permitir pagos por PSE (Pago Seguro en Línea) o FC (Financiera Comultrasan).

# Historias de Usuario

## Administrador de la entidad
- Quiero poder crear formularios para distintos tipos de situaciones de pago para que sean seleccionados por los usuarios.
- Quiero poder limitar la cantidad de códigos QRs activos simultaneos de los usuarios para administrarlos.
- Quiero que la interfaz de generación de formularios sea intuitiva para optimizar el proceso.
- Quiero poder asignar o remover la posibilidad de generar códigos a cada usuario.

## Usuario de la entidad
- Quiero poder visualizar mi información de cuenta como saldo y número de cuenta para mi conocimiento.
- Quiero que la interfaz de generación de códigos de pago sea sencilla e intuitiva para poder obtener los códigos de forma práctica.
- Quiero poder generar códigos de pago con un formato fácilmente compartible como un enlace corto o código QR para enviarlo al pagador.
- Quiero poder generar códigos de pago con información de fecha y hora de generación para verificarlos en el futuro en caso de ser necesario.
- Quiero poder definir datos prellenados en mis códigos de pago, como monto, descripción e identificación del pagador para que no puedan ser modificados por el pagador.
- Quiero poder personalizar la interfaz de mis códigos de pago con una imagen o logo para que el pagador pueda reconocer facilmente mi identidad.
- Quiero poder seleccionar un tipo de formulario para cada código de pago, de acuerdo a los formularios definidos por la entidad para que el pagador complete los datos requeridos.
- Quiero poder administar mi código de pago; terminar su validez para no permitir que se sigan realizando pagos después de que yo así lo decida.
- Quiero ver la información de los pagos realizados por mis clientes o asociados para mi conocimiento.
- Quiero poder ocultar el saldo de mi cuenta en pantalla para mayor privacidad.

## Pagador (cliente del usuario)
- Quiero poder acceder a la interfaz generada con el código de pago para realizar el llenado del formulario y el pago correspondiente.
- Quiero que el formulario de pago sea *responsive* para una mejor experiencia
- Quiero que el formulario de pago valide la información ingresada para tener mayor seguridad.
- Quiero poder realizar el pago mediante PSE (Pago Seguro Electrónico) para completar la transacción a través de otras entidades financieras.
- Quiero poder realizar el pago a través de FC (Financiera Comultrasan) para completar la transacción.
- Quiero poder generar un comprobante de pago de mi transacción para confirmar el pago.
- Quiero poder compartir el comprobante previamente generado para confirmar con el usuario o con un tercero.
## Sistema
- Quiero poder consultar la información de los pagos realizados como la fecha y hora de la transacción así como la dirección IP y fingerprint del pagador para mayor seguridad.