package com.sura.pruebatecnica.correoelectronico.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class IngresoSitioWebPages extends PageObject {

    @FindBy(xpath = "//*[@id=\"view_container\"]/form/div[2]/div/div[1]/div[1]/div/div[1]")
    private WebElementFacade correo;
    @FindBy(xpath = "..//*[@id='password']/div[1]/div/div[1]/input")
    private WebElementFacade password;
    @FindBy(xpath = ".//*[@id='identifierNext']/content/span")
    private WebElementFacade btnSiguiente;
    @FindBy(xpath = ".//*[@id='gb']/div[1]/div[3]")
    private WebElementFacade buscadorPantallaPpal;

    public IngresoSitioWebPages(WebDriver driver) {super(driver); }

    public void accesoAplicativoCorreo(String contexto) {
        getDriver().navigate().to(contexto);
        //setImplicitTimeout(VALUE_1, TimeUnit.SECONDS);
        //if (btnLogIn.isPresent()) {
          //  btnLogIn.click();
        //}
        //resetImplicitTimeout();
    }
    public void inicioDesesion(String usuario, String contrasenia) {
        setImplicitTimeout(0, TimeUnit.SECONDS);
        if (!buscadorPantallaPpal.isPresent()) {
            correo.clear();
            correo.sendKeys(usuario);
            btnSiguiente.click();
            password.clear();
            password.sendKeys(contrasenia);
            btnSiguiente.click();
        }
    }
}
