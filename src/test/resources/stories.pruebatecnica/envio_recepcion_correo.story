Meta:

Narrative:
Como usuario de Gmail, quiero realizar un envío de un correo electrónico, para validar la información y recepción del correo enviado.

Scenario: Envio y recepcion de correo electronico en gmail cp1
Given estoy cargando el sitioweb de gmail: https://gmail.com
When voy a iniciar sesion, con el email <correo> y password <pass>
And seleccione la opcion de redactar

Examples:
| correo            | pass  |
| restrej@gmail.com | restre|

Scenario: Valido en el inbox cp2
Given estoy en el inbox
When verifico correos enviados
Then mostrar mensaje enviado

Examples:
| correo            | pass  |
| restrej@gmail.com | restre|
