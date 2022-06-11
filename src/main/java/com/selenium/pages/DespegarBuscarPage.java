package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DespegarBuscarPage {
	@FindBy(css = "div.results-items-wrapper div.results-cluster-container:nth-child(1) button>em")
	private WebElement resultado;
	
	@FindBy(css= "div.message-header")
	private WebElement sinReservas;
	
	private WebDriver driver = null;

	public DespegarBuscarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean hotelExist() {
		try {
			Thread.sleep(2000);
			Reporter.log("No hay hoteles disponibles en la locación");
			return true;
			
		}catch(Exception e) {
			resultado.isDisplayed();
			return false;
		}
	}

	public boolean SinReservas() {
		return this.sinReservas.isDisplayed();
	}
}
