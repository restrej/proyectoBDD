package com.sura.junit;

import com.sura.pruebatecnica.correoelectronico.pages.IngresoSitioWebPages;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.junit.Test;

public class PruebasUnitarias {
    @Page
    IngresoSitioWebPages ingresoSitioWebPages;



    @Test
    public void decodeBase64Test(){
        Assert.assertEquals("decodePrueba",ingresoSitioWebPages.inicioDeSesion("ddsfsdfdsfsdfsfsd"));
    }


}
