package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class WikiTests2{
	private WebDriver navegador = null;

	@BeforeClass(alwaysRun=true)
	public void NavegadorTest(ITestContext context) throws Exception {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegadorSuite = navegadorTestSuite != null ? navegadorTestSuite : "EDGE";
		navegador = DriverFactory.LevantarBrowser(null, navegadorSuite, "https://www.wikipedia.com.ar/");
	}

	@DataProvider(name = "buscar")
	public Object[][] getData() {
		return new Object[][] { { "Selenium" }, { "Piccaso" }, { "Argentina" } };
	}
	
	@Test(dataProvider = "buscar", description="Validar que las busquedas en wiki funcionan")
	public void ValidarBusquedaWikiPedia(String Busqueda) throws Exception {
		WikiPrincipalPage homePage = new WikiPrincipalPage(navegador);
		Assert.assertTrue(homePage.searchInputesVisible(),"El input no esta visible");
		WikiBuscarPage resultPage = homePage.searchInput(Busqueda);
		Assert.assertTrue(resultPage.tituloVisible(),"El título no esta visible");
	}
	
	@AfterMethod
	public void endSetup() {
		navegador.close();
	}
}
