package com.selenium.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium.driver.*;

public class DespegarLista {
	@Test(description = "Validar Clickear cada boton de la barra superior de la pagina de despegar.com")
	public void validarCiclo() throws Exception{		
		WebDriver driver = DriverFactory.LevantarBrowser(null, "EDGE", "https://www.despegar.com.ar/");
		
		List<WebElement> listaElementos = driver.findElements(By.xpath("//ul[@class='header-list-products']/li"));
		for(WebElement elemento : listaElementos) {
			//WebElement aElemento = elemento.findElement(By.xpath("//a[@title]"));
			//aElemento.click();
			System.out.print(elemento.getText() + " | ");
			Assert.assertTrue(elemento.isDisplayed());
			Thread.sleep(2000);
		}
		 
		driver.close();  
  }
}
