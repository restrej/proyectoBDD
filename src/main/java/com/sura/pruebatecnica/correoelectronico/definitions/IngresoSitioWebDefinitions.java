package com.sura.pruebatecnica.correoelectronico.definitions;

import com.sura.pruebatecnica.correoelectronico.steps.IngresoSitioWebSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

public class IngresoSitioWebDefinitions {

    @Steps
    IngresoSitioWebSteps ingresoSitioWebSteps;


    @Given("estoy cargando el sitioweb de gmail: $urlSitioWeb")
    public void cargaSitioWeb(String urlSitioWeb) {
        ingresoSitioWebSteps.accesoAplicativoCorreo(urlSitioWeb);
    }

    @When("se realiza el inicio de sesion, con el email <correo> y password <pass>")
    public void inicioDesesion(@Named("correo") String email, @Named("pass") String password) {
        ingresoSitioWebSteps.inicioDesesion(email, password);
    }
}
