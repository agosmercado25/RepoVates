package com.selenium.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.*;

public class WikiTest1 {
	private WebDriver navegador = null;

	@BeforeClass(alwaysRun=true)
	public void NavegadorTest() throws Exception {
		WebDriver navegador = DriverFactory.LevantarBrowser(null, "EDGE", "https://www.wikipedia.com.ar/");
		WebDriverWait wait = new WebDriverWait(navegador, 5);
	}

	@Test
	public void BusquedaWiki() {
		WikiPrincipalPage wiki = new WikiPrincipalPage(navegador);
		Assert.assertTrue(wiki.searchInputesVisible(),"Error!");
		WikiBuscarPage buscar = wiki.searchInput("Selenium");
		Assert.assertTrue(buscar.tituloVisible());
	}

	@AfterClass
	public void endSetup() {
		navegador.close();
	}
}
