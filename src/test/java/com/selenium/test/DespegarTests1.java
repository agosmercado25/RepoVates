package com.selenium.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.pages.*;


public class DespegarTests1{
	private WebDriver navegador = null;
	
	@BeforeClass(alwaysRun=true)
	public void NavegadorTest() throws Exception {
	WebDriver navegador = DriverFactory.LevantarBrowser(null, "EDGE", "https://www.despegar.com.ar/");
	WebDriverWait wait = new WebDriverWait(navegador, 5);
	}
	
	@Test
	public void AlojamientoTest() throws InterruptedException{
		DespegarPrincipalPage home = new DespegarPrincipalPage(navegador);
		Assert.assertTrue(home.DespegarVisible());
		home.iraAlojamiento();
		DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(navegador);
		alojamiento.alojamiento("Córdoba, Cordoba, Argentina");
		DespegarBuscarPage result = new DespegarBuscarPage(navegador);
		Assert.assertTrue(result.Resultado());
		result.Pr();
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		navegador.close();
	}
}
