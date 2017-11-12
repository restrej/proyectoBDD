package com.sura.pruebatecnica.correoelectronico.definitions;

import com.sura.pruebatecnica.correoelectronico.steps.IngresoSitioWebSteps;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;
import org.seleniumhq.jetty9.util.annotation.Name;

public class IngresoSitioWebDefinitions {

    @Steps
    IngresoSitioWebSteps ingresoSitioWebSteps;


    @Given("estoy cargando el sitioweb de gmail: $urlSitioWeb")
    public void accesoAplicativoCorreo(String urlSitioWeb) {
        ingresoSitioWebSteps.accesoAplicativoCorreo(urlSitioWeb);
    }

    @When("voy a iniciar sesion, con el email <correoRemitente> y password <pass>")
    @Alias("voy a iniciar sesion con correo destinatario, con el email <correoRemitente> y password <pass>")
    public void inicioDeSesion(@Named("correoRemitente") String email, @Named("pass") String password) {
        ingresoSitioWebSteps.inicioDeSesion(email, password);
    }

    @When("seleccione la opcion de redactar")
    public void redactarCorreo() {
        ingresoSitioWebSteps.redactarCorreo();
    }

    @When("indique el <destinatario>, el <asunto> y la <descripcion> del mensaje")
    public void datosCorreo(@Named("destinatario") String email, @Named("asunto") String asunto,@Named("descripcion") String cuerpocorreo) {
        ingresoSitioWebSteps.datosCorreo(email, asunto, cuerpocorreo);
    }

    @When("seleccionar la opcion de enviar")
    public void enviarCorreo(){
        ingresoSitioWebSteps.enviarCorreo();
    }

    @When("ingresar al primer correo principal")
    public void correoPrincipal(){
        ingresoSitioWebSteps.correoPrincipal();
    }

    @When("voy a seleccionar la opcion de usar otra cuenta")
    public void opcionOtraCuenta(){
        ingresoSitioWebSteps.opcionOtraCuenta();
    }

    @Then("debe mostrar una notificacion indicando que el mensaje ha sido enviado")
    @Manual
    public void validarMensajeCorreo(){
    }

    @Then("se debe seleccionar la opcion Cuenta de Google")
    public void opcionCuentaGoogle(){
        ingresoSitioWebSteps.opcionCuentaGoogle();
    }

    @Then("voy a ingresar a la opcion Cerrar sesion")
    public void cerrarSesion(){
        ingresoSitioWebSteps.cerrarSesion();
    }

    @Then("se debe mostrar el asunto del mensaje y descripcion del cuerpo del mensaje")
    public void validarMensaje(){
        ingresoSitioWebSteps.validarMensaje();
    }
}
