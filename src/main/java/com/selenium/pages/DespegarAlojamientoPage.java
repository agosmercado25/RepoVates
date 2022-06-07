package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientoPage {
	@FindBy(css = ".ac-container .item-text")
	WebElement destino;
	@FindBy(css = "div.input-container>input[placeholder='Ingresá una ciudad, alojamiento o punto de interés'")
	WebElement ciudad;
	
	@FindBy(css = ".input-container .input-tag[placeholder='Entrada']")
	WebElement calendarioEntrada;
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-06'] //div[@class='sbox5-monthgrid-datenumber']//div [text()='15']")
	WebElement fechaEntrada;
	
	@FindBy(css = ".input-container .input-tag[placeholder='Salida']")
	WebElement calendarioSalida;
	@FindBy(xpath = "//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-06'] //div[@class='sbox5-monthgrid-datenumber sbox5-monthgrid-datenumber-20']")
	WebElement fechaSalida;
	
	@FindBy(css = ".sbox5-floating-tooltip-opened .calendar-footer .btn-text")
	WebElement btnApply;
	
	@FindBy(css = ".sbox5-box-distributionPassengers-ovr")
	WebElement habitaciones;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")
	WebElement cantAdultos;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")
	WebElement cantNiños;
	@FindBy(css = ".select-option[value='5']")
	WebElement edadNiño;
	@FindBy(css = "div.sbox5-floating-tooltip-opened div.stepper__room__footer>a:nth-child(1)")
	WebElement btnApply2;
	
	@FindBy(css = "div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text")
	WebElement btnBuscar;

	@FindBy(css = ".login-incentive .shifu-3-icon-close")
	WebElement loginInteractiv;
	private WebDriver driver = null;

	public DespegarAlojamientoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriverWait wait(WebElement locator) {
		return this.wait(locator);
	}

	public DespegarBuscarPage alojamiento(String ciudad) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		loginInteractiv.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sbox5-box-places-ovr .input-container")));
		this.ciudad.click();
		this.ciudad.sendKeys(ciudad);
		this.ciudad.sendKeys(Keys.CONTROL);
		this.ciudad.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac-container .item-text")));
		destino.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input1\"]")));
		calendarioEntrada.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='10']")));
		fechaEntrada.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input2-container\"]")));
		calendarioSalida.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//*[@class='sbox5-monthgrid-datenumber-number'][text()='14']")));
		fechaSalida.click();
		btnApply.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sbox5-box-distributionPassengers-ovr")));
		habitaciones.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")));
		cantAdultos.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")));
		cantNiños.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select-option[value='5']")));
		edadNiño.click();
		btnApply2.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text")));
		btnBuscar.click();
		return new DespegarBuscarPage(driver);
	}
}
