package com.selenium.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.*;

public class WikiTest1 {
	private WebDriver navegador = null;

	@BeforeClass(alwaysRun=true)
	public void NavegadorTest(ITestContext context) throws Exception {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegadorSuite = navegadorTestSuite != null ? navegadorTestSuite : "EDGE";
		navegador = DriverFactory.LevantarBrowser(null, navegadorSuite, "https://www.wikipedia.com.ar/");
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
