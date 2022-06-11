package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPrincipalPage {

	@FindBy(id = "searchInput")
	private WebElement searchInput;
	 
	private WebDriver driver = null;

	public WikiPrincipalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean searchInputesVisible() {
		return this.searchInput.isDisplayed();
	}
	
	public WikiBuscarPage searchInput(String text) {
		this.searchInput.sendKeys(text);
		searchInput.submit();
		return new WikiBuscarPage(this.driver);
	}

}
