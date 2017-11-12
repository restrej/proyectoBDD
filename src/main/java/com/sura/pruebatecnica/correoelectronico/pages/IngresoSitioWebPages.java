package com.sura.pruebatecnica.correoelectronico.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang.UnhandledException;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(xpath = ".//div[contains(.,'Tu mensaje ha sido enviado.')")
    private WebElementFacade mensajeValidacionCorreo;
    @FindBy(xpath = ".//*[@class='gb_bb gbii']")
    private WebElementFacade btnCuentaGoogle;
    @FindBy(xpath = ".//*[text()='Cerrar sesión']")
    private WebElementFacade btnCerrarSesion;
    @FindBy(xpath = ".//*[@class='J-Ke n0 aBU']")
    private WebElementFacade btnRecibidos;
    @FindBy(xpath = ".//body/div/div/div/div/form/div/div/div/div/div")
    private WebElementFacade btnOtraCuenta;
    @FindBy(xpath = ".//div[@class='TnvOCe k6Zj8d XraQ3b bLzI3e']/div[2]/p")
    private WebElementFacade opcionUsarOtraCuenta;
    @FindBy(xpath = ".//*[@class='asf T-I-J3 J-J5-Ji']")
    private WebElementFacade actualizar;
    @FindBy(xpath = ".//*[@class='bog']")
    private WebElementFacade mensajeCorreoPrinciial;


    public IngresoSitioWebPages(WebDriver driver) {super(driver); }

    public void accesoAplicativoCorreo(String contexto) {
            getDriver().navigate().to(contexto);
    }

    public void inicioDeSesion(String usuario, String contrasenia) {
        Serenity.setSessionVariable("Remitente").to(usuario);
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
        Serenity.setSessionVariable("asuntoCorreo").to(asunto);
        Serenity.setSessionVariable("descripcionCorreo").to(descripcion);
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

    public void opcionCuentaGoogle(){
        btnCuentaGoogle.click();
    }

    public void cerrarSesion(){
        waitFor(btnCerrarSesion);
        btnCerrarSesion.click();
    }

    public void correoPrincipal( ){
        mensajeCorreoPrinciial.isVisible();
        mensajeCorreoPrinciial.click();
    }

    public void opcionOtraCuenta(){
        waitFor(btnOtraCuenta);
        btnOtraCuenta.isVisible();
        btnOtraCuenta.click();
        opcionUsarOtraCuenta.isVisible();
        opcionUsarOtraCuenta.click();
    }

    public void validarMensaje(){
        String correoAsunto = Serenity.sessionVariableCalled("asuntoCorreo").toString();
        WebElementFacade asuntoContacto = findBy(".//span[contains(.,'" + correoAsunto + "')]");
        MatcherAssert.assertThat(asuntoContacto.getText(),Is.is(Matchers.equalTo(correoAsunto)));
    }
}
