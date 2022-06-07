package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DespegarPrincipalPage {
  @FindBy(css = "a. lgpd-banner--button")
  private WebElement cookies;
  
  @FindBy(xpath = "//i[@class='login-incentive--close shifu-3-icon-close -eva-3-mr-md']")
  private WebElement btnIniciarSesion;
  
  @FindBy(css = "div.header-products-container>ul>li>a[title ='Alojamientos']")
  private WebElement alojamiento;
  
  private WebDriver driver = null;
  
  public DespegarPrincipalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean DespegarVisible() {
		return this.alojamiento.isDisplayed();
	}
	 
	public DespegarAlojamientoPage iraAlojamiento() {
		btnIniciarSesion.click();
		cookies.click();
		alojamiento.click();
		return new DespegarAlojamientoPage(this.driver);
	} 
}
