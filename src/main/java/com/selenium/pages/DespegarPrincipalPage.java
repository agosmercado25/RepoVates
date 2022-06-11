package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DespegarPrincipalPage {
	
	private WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css = "a.lgpd-banner--button")
	private WebElement cookies;
	  
	@FindBy(css = ".login-incentive .shifu-3-icon-close")
	private WebElement login;
	  
	@FindBy(css = ".header-products-container [href='//www.despegar.com.ar/hoteles/']")
	private WebElement alojamiento;
  
	public DespegarPrincipalPage(WebDriver driver) {
	  	this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 5);
	}
  
	public boolean DespegarVisible() {
		return this.alojamiento.isDisplayed();
	}
	 
	public DespegarAlojamientoPage iraAlojamiento() {
		wait.until(ExpectedConditions.elementToBeClickable(alojamiento));
		Assert.assertTrue(alojamiento.isDisplayed(),"Error! No accede a la pagina");
		login.click();
		wait.until(ExpectedConditions.elementToBeClickable(cookies));
		cookies.click();
		alojamiento.click();
		return new DespegarAlojamientoPage(this.driver);
	} 
}
