Meta:

Narrative:
Como usuario de Gmail, quiero realizar un envío de un correo electrónico, para validar la información y recepción del correo enviado.

Scenario: Loguin al servidor de correo Gmail para (envío y recepción) de información
Given estoy cargando el sitioweb de gmail: https://gmail.com
When voy a iniciar sesion, con el email <correo> y password <pass>
And seleccione la opcion de redactar
And indique el <destinatario>, el <asunto> y la <descripcion> del mensaje
And seleccionar la opcion de enviar
Then debe mostrar un mensaje <mensaje> indicando que el correo ha sido enviado

Examples:
|correo           |pass  |destinatario               |asunto                  |descripcion                                                    |mensaje                                   |
|restrej@gmail.com|restre|maribelmendez2790@gmail.com|prueba emvio y recepcion|Este es un correo de prueba de envio y recepcion de informacion|Tu mensaje ha sido enviado. Ver el mensaje|