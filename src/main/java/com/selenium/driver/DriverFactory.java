package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

public class DriverFactory {
	private enum browsers{
		EDGE, FIREFOX, CHROME
	};
  //@Test
  public static WebDriver LevantarBrowser (WebDriver driver, String browserName, String url) 
  {
	  switch (browsers.valueOf(browserName)) {
	  case CHROME:
	  {
		  System.setProperty("webdriver.chrome.driver", "D:/Instalaciones/chromedriver_win32/chromedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new ChromeDriver();
		  break;
	  }
	  case EDGE:
	  {
		  System.setProperty("webdriver.edge.driver", "D:/Instalaciones/edgedriver_win64/msedgedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new EdgeDriver();
		  break;
	  }
	  case FIREFOX:
	  {
		  System.setProperty("webdriver.firefox.driver", "D:/Instalaciones//geckodriver-v0.31.0-win64/geckodriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new FirefoxDriver();
		  break;
	  }
	  default:
		  //Versión 102.0.1245.30 (Compilación oficial) (64 bits)
		  Reporter.log("No selecciono ningun browser correcto, se le asginara edge");
		  System.setProperty("webdriver.edge.driver", "D:/Instalaciones/edgedriver_win64/msedgedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new EdgeDriver();
		  break;
	  }
	  
	  //Maximizar
	  driver.manage().window().maximize();
	  
	  driver.get(url);
	
	  return driver;
  }
  
  public static void CerrarBrowser(WebDriver driver) {
	  driver.quit();
  }
}