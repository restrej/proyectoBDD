package com.sura.pruebatecnica.correoelectronico.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang.UnhandledException;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IngresoSitioWebPages extends PageObject {

    @FindBy(xpath = ".//*[@id='identifierId']")
    private WebElementFacade correo;
    @FindBy(xpath =".//input[@name='password']")
    private WebElementFacade password;
    @FindBy(xpath = ".//*[@id='identifierNext']/content/span")
    private WebElementFacade btnSiguiente;
    @FindBy(xpath = ".//*[@id='gb']/div[1]/div[3]")
    private WebElementFacade buscadorPantallaPpal;
    @FindBy(xpath = "//*[@id=\'passwordNext\']/content/span")
    private WebElementFacade btnSiguientePass;
    @FindBy(xpath = ".//*[text()='REDACTAR']")
    private WebElementFacade btnRedactar;
    @FindBy(className = "vO")
    private WebElementFacade campoDestinatario;
    @FindBy(xpath = ".//*[@class='aoT']")
    private WebElementFacade campoAsunto;
    @FindBy(xpath = ".//*[@class='Am Al editable LW-avf']")
    private WebElementFacade campoCuerpoMensaje;
    @FindBy(xpath = ".//*[text()='Enviar']")
    private WebElementFacade btnEnviar;
    @FindBy(xpath = ".//*[@id='']")
    private WebElementFacade mensajeValidacionCorreo;


    public IngresoSitioWebPages(WebDriver driver) {super(driver); }

    public void accesoAplicativoCorreo(String contexto) {
            getDriver().navigate().to(contexto);
    }

    public void inicioDeSesion(String usuario, String contrasenia) {
        setImplicitTimeout(3, TimeUnit.SECONDS);
        correo.sendKeys(usuario);
        btnSiguiente.click();
        waitFor(password);
        password.sendKeys(contrasenia);
        password.sendKeys(Keys.ENTER);
    }

    public void redactarCorreo(){
        btnRedactar.isVisible();
        btnRedactar.click();
    }

    public void datosCorreo(String email, String asunto, String descripcion ){
        campoDestinatario.clear();
        campoDestinatario.sendKeys(email);
        campoAsunto.clear();
        campoAsunto.sendKeys(asunto);
        campoCuerpoMensaje.sendKeys(descripcion);
    }

    public void enviarCorreo(){
        btnEnviar.isVisible();
        btnEnviar.click();
    }

    public void validarMensajeCorreo(String mensaje){
        MatcherAssert.assertThat(mensajeValidacionCorreo.getText(), Is.is(Matchers.equalTo(mensaje)));
    }
}
