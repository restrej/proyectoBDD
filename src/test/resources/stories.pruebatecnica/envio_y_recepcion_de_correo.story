Meta:

Narrative:
Envío y recepción de correo electronico en gmail, para validar la información.

Scenario: Envio y recepcion de correo electronico en gmail
Given estoy cargando el sitioweb de gmail: https://gmail.com
When se realiza el inicio de sesion, con el email <correo> y password <pass>

Examples:
| correo            | pass  |
| restrej@gmail.com | restre|
