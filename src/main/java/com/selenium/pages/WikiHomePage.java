package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;


public class WikiHomePage {
	WebDriver driver;
	
	public WikiHomePage(WebDriver Idriver) {
		this.driver = Idriver;
	}
	
	@FindBy(id = "searchInput")
	private WebElement txtCajaBusqueda;
	
	public void IngresarDatoCajaBusqueda (String dato) {
		Reporter.log("Localizar y comprobar que la caja de bsuqueda se muestra");
		Assert.assertTrue((txtCajaBusqueda.isDisplayed()), "La caja no se visualiza");
		Reporter.log("Ingresar la palabra Selenium");
		txtCajaBusqueda.sendKeys(dato);
		Reporter.log("Presionar Enter");
		
		txtCajaBusqueda.sendKeys(Keys.ENTER);
	}
}
