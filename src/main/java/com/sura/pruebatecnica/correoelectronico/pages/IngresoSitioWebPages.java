package com.sura.pruebatecnica.correoelectronico.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class IngresoSitioWebPages extends PageObject {

    @FindBy(xpath = ".//*[@id=\'identifierId\']")
    private WebElementFacade correo;
    @FindBy(xpath = "//*[@id=\'password\']/div[1]/div/div[1]/input")
    private WebElementFacade password;
    @FindBy(xpath = ".//*[@id='identifierNext']/content/span")
    private WebElementFacade btnSiguiente;
    @FindBy(xpath = ".//*[@id='gb']/div[1]/div[3]")
    private WebElementFacade buscadorPantallaPpal;
    @FindBy(xpath = "//*[@id=\'passwordNext\']/content/span")
    private WebElementFacade btnSiguientePass;



    public IngresoSitioWebPages(WebDriver driver) {super(driver); }

    public void accesoAplicativoCorreo(String contexto) {
            getDriver().navigate().to(contexto);
    }
    public void inicioDesesion(String usuario, String contrasenia) {
        setImplicitTimeout(0, TimeUnit.SECONDS);
            correo.clear();
            correo.sendKeys(usuario);
            btnSiguiente.click();
            password.clear();
            password.sendKeys(contrasenia);
            btnSiguientePass.click();
    }
}
