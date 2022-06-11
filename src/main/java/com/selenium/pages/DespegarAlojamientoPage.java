package com.selenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientoPage {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	@FindBy(css = "div.input-container>input[placeholder='Ingresá una ciudad, alojamiento o punto de interés'")
	WebElement ciudad;
	@FindBy(css = "div.ac-wrapper.-show>div>div>ul>li")
	private WebElement modalCiudad;
	
	@FindBy(css = ".input-container .input-tag[placeholder='Entrada']")
	private WebElement calendarioEntrada;
	@FindBy(css = "div.sbox5-floating-tooltip-opened div.calendar-container div.-today")
	private WebElement fechaIngreso;
	
	@FindBy(css = ".input-container .input-tag[placeholder='Salida']")
	private WebElement calendarioSalida;
	@FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.sbox5-3-floating-tooltip-datepicker-wrapper.sbox5-compact-view div.calendar-container > div.sbox5-monthgrid.sbox5-compact-view:nth-child(3) div.sbox5-monthgrid-datenumber.sbox5-monthgrid-datenumber-28")
	private WebElement fechaSalida;
	
	@FindBy(css = "div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text")
	private WebElement btnApply;
	
	@FindBy(css = ".sbox5-box-distributionPassengers-ovr")
	private WebElement habitaciones;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")
	private WebElement cantAdultos;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")
	private WebElement cantNiños;
	@FindBy(css = ".select-option[value='5']")
	private WebElement edadNiño;
	@FindBy(css = "div.sbox5-floating-tooltip-opened div.stepper__room__footer>a:nth-child(1)")
	private WebElement btnApply2;
	
	@FindBy(css = "div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text")
	private WebElement btnBuscar;

	public DespegarAlojamientoPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}
	
	public void ingresarCiudad(String txt) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(ciudad));
		ciudad.click();
		ciudad.sendKeys(txt);
		Thread.sleep(1000);
		ciudad.sendKeys(Keys.CONTROL);
		wait.until(ExpectedConditions.elementToBeClickable(modalCiudad));
		ciudad.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	public void ingresarFechaEntrada() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(calendarioEntrada));
		calendarioEntrada.click();
		wait.until(ExpectedConditions.elementToBeClickable(fechaIngreso));
		fechaIngreso.click();
		Thread.sleep(1000);
	}
	
	public void ingresarFechaSalida() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(calendarioSalida));
		calendarioSalida.click();
		wait.until(ExpectedConditions.elementToBeClickable(fechaSalida));
		wait.until(ExpectedConditions.visibilityOfAllElements(fechaSalida));
		fechaSalida.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnApply));
		btnApply.click();
		Thread.sleep(1000);
	}
	
	public void cantidadViajeros() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(habitaciones));
		habitaciones.click();
		wait.until(ExpectedConditions.elementToBeClickable(cantAdultos));
		cantAdultos.click();
		wait.until(ExpectedConditions.elementToBeClickable(cantNiños));
		cantNiños.click();
		wait.until(ExpectedConditions.elementToBeClickable(edadNiño));
		edadNiño.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnApply2));
		btnApply2.click();
		Thread.sleep(1000);
	}
	
	public WebDriverWait wait(WebElement locator) {
		return this.wait(locator);
	}

	public DespegarBuscarPage alojamiento(String lugar) throws Exception {
		ingresarCiudad(lugar);
		ingresarFechaEntrada();
		ingresarFechaSalida();
		cantidadViajeros();
		wait.until(ExpectedConditions.elementToBeClickable(btnBuscar));
		btnBuscar.click();
		Thread.sleep(1000);
		return new DespegarBuscarPage(driver);
	}

}