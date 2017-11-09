package com.sura.pruebatecnica.correoelectronico.steps;

import com.sura.pruebatecnica.correoelectronico.pages.IngresoSitioWebPages;
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
    public void inicioDesesion(String usuario, String contrasenia) {
        ingresoSitioWebPages.inicioDesesion(usuario, contrasenia);
    }
}
