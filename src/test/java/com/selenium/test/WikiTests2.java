package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class WikiTests2{
	private WebDriver driver = null;

	@BeforeClass(alwaysRun=true)
	public void NavegadorTest() throws Exception {
		WebDriver navegador = DriverFactory.LevantarBrowser(null, "EDGE", "https://www.wikipedia.com.ar/");
		WebDriverWait wait = new WebDriverWait(navegador, 5);
	}

	@Test(dataProvider = "buscar")
	public void ValidarBusquedaWikiPedia(String Busqueda) throws Exception {
		WikiPrincipalPage homePage = new WikiPrincipalPage(driver);
		Assert.assertTrue(homePage.searchInputesVisible());
		WikiBuscarPage resultPage = homePage.searchInput(Busqueda);
		Assert.assertTrue(resultPage.tituloVisible());
	}

	@AfterMethod
	public void endSetup() {
		driver.close();
	}

	@DataProvider(name = "buscar")
	public Object[][] getData() {
		return new Object[][] { { " Selenium" }, { " Piccaso" }, { " Argentina" } };

	}
}
