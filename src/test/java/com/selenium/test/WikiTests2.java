package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		navegador = DriverFactory.LevantarBrowser(null, navegadorSuite, "https://es.wikipedia.org/wiki/Wikipedia:Portada");
	}

	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia() throws Exception {
		WebElement findE = navegador.findElement(By.xpath("//* [@title='Portal:Actualidad']"));
		Assert.assertTrue(findE.isDisplayed());
		String elemento = "Actualidad";
		Assert.assertEquals(findE.getText(), elemento, "Error!");
		WebElement tituloResultado = navegador.findElement(By.id("firstHeading"));
		System.out.println("TEXTO ENCONTRADO"+ tituloResultado.getText());
	}
	
	@AfterMethod
	public void endSetup() {
		navegador.close();
	}
}
