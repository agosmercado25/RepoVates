package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarBuscarPage {
	@FindBy(css = ".results-cluster-container:nth-child(1) .btn-text")
	private WebElement resultado;
	
	private WebDriver driver = null;

	public DespegarBuscarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean Resultado() {
		return this.resultado.isEnabled();
	}
}
