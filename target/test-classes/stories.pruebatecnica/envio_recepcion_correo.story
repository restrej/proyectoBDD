Meta:

Narrative:
Como usuario de Gmail, quiero realizar un envío de un correo electrónico, para validar la información y recepción del correo enviado.

Scenario: Loguin al servidor de correo gmail para (envío y recepción) de información
Given estoy cargando el sitioweb de gmail: https://gmail.com
When voy a iniciar sesion, con el email <correoRemitente> y password <pass>
And seleccione la opcion de redactar
And indique el <destinatario>, el <asunto> y la <descripcion> del mensaje
And seleccionar la opcion de enviar
Then debe mostrar una notificacion indicando que el mensaje ha sido enviado
And se debe seleccionar la opcion Cuenta de Google
And voy a ingresar a la opcion Cerrar sesion

Examples:
|correoRemitente  |pass  |destinatario               |asunto                  |descripcion                                                    |
|restrej@gmail.com|restre|maribelmendez2790@gmail.com|prueba envio y recepcion|Este es un correo de prueba de envio y recepcion de informacion|

Scenario: Recepción de correo electronico en la bandeja de entrada gmail
Given estoy cargando el sitioweb de gmail: https://gmail.com
When voy a seleccionar la opcion de usar otra cuenta
And voy a iniciar sesion con correo destinatario, con el email <correoRemitente> y password <pass>
Then se debe mostrar el asunto del mensaje y descripcion del cuerpo del mensaje


Examples:
|correoRemitente            |pass     |
|maribelmendez2790@gmail.com|maribel27|

Scenario: Redacción Correo con copias Cc (Envío)
Meta:
@manual
Given estoy enviando un correo en gmail
When voy a ingresar un valor existente en el campo "Correo destino"
And voy a seleccionar la opción "Cc"
And voy a ingresar un valor existente en el campo "Cc"
And voy a ingresar un valor en el campo "Asunto" del mensaje
And voy a ingresar una descripción en  el cuerpo del mensaje
And seleccionar enviar
Then se debe mostrar correctamente el mensaje "Tu mensaje ha sido enviado. Ver el mensaje


Scenario: Redacción Correo con copia Oculta Cco (Envío)
Meta:
@manual
Given estoy enviando un correo en gmail
When voy a ingresar un valor existente en el campo "Correo destino"
And voy a Seleccionar la opción "Cco"
And voy a ingresar un valor existente en el campo "Cco""
And voy a ingresar un valor en el campo "Asunto" del mensaje
And voy a ingresar una descripción en  el cuerpo del mensaje
And seleccionar enviar
Then se debe mostrar correctamente el mensaje "Tu mensaje ha sido enviado. Ver el mensaje

Scenario: Redacción Correo con dato adjunto (Envío)
Meta:
@manual
Given estoy enviando un correo en gmail
When voy a ingresar un valor existente en el campo "Correo destino"
And voy a ingresar un valor en el campo "Asunto" del mensaje
And voy a ingresar una descripción en  el cuerpo del mensaje
And Seleccionar la opción "Adjuntar Archivos"
And seleccionar enviar
Then se debe mostrar correctamente el mensaje "Tu mensaje ha sido enviado. Ver el mensaje


Scenario: Redacción Correo (Envío en borrador)
Meta:
@manual
Given estoy enviando un correo en gmail
When voy a ingresar un valor existente en el campo "Correo destino"
And voy a ingresar un valor en el campo "Asunto" del mensaje
And voy a ingresar una descripción en  el cuerpo del mensaje
And seleccionar la opción "Guardar y cerrar"
And seleccionar enviar
Then se debe mostrar la información del mensaje No enviado. En la bandeja de borradores
