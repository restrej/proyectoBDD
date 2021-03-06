package com.sura.pruebatecnica.correoelectronico.steps;

import com.sura.pruebatecnica.correoelectronico.pages.IngresoSitioWebPages;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import org.fluentlenium.core.annotation.Page;

public class IngresoSitioWebSteps {

    @Page
    IngresoSitioWebPages ingresoSitioWebPages;

    @Step
    public void accesoAplicativoCorreo(String contexto) {
        ingresoSitioWebPages.accesoAplicativoCorreo(contexto);
    }

    @Step
    public void inicioDeSesion(String usuario, String contrasenia) {
        ingresoSitioWebPages.inicioDeSesion(usuario, contrasenia);
    }

    @Step
    public void redactarCorreo(){
        ingresoSitioWebPages.redactarCorreo();
    }

    @Step
    public void datosCorreo(String email, String asunto, String descripcion){
        ingresoSitioWebPages.datosCorreo(email, asunto, descripcion);
    }

    @Step
    public void enviarCorreo(){
        ingresoSitioWebPages.enviarCorreo();
    }

    @Step
    public void opcionCuentaGoogle(){
        ingresoSitioWebPages.opcionCuentaGoogle();
    }

    @Step
    public void cerrarSesion(){
        ingresoSitioWebPages.cerrarSesion();
    }

    @Step
    public void correoPrincipal(){
        ingresoSitioWebPages.correoPrincipal();
    }

    @Step
    public void opcionOtraCuenta(){
        ingresoSitioWebPages.opcionOtraCuenta();
    }

    @Step
    public void validarMensaje(){
        ingresoSitioWebPages.validarMensaje();
    }

}
