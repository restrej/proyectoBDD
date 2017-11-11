package com.sura.pruebatecnica.correoelectronico.definitions;

import com.sura.pruebatecnica.correoelectronico.steps.IngresoSitioWebSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

public class IngresoSitioWebDefinitions {

    @Steps
    IngresoSitioWebSteps ingresoSitioWebSteps;


    @Given("estoy cargando el sitioweb de gmail: $urlSitioWeb")
    public void accesoAplicativoCorreo(String urlSitioWeb) {
        ingresoSitioWebSteps.accesoAplicativoCorreo(urlSitioWeb);
    }

    @When("voy a iniciar sesion, con el email <correo> y password <pass>")
    public void inicioDeSesion(@Named("correo") String email, @Named("pass") String password) {
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

    @Then("debe mostrar un mensaje <mensaje> indicando que el correo ha sido enviado")
    public void validarMensajeCorreo(@Named("mensaje") String mensaje) {
        ingresoSitioWebSteps.validarMensajeCorreo(mensaje);
    }

}
