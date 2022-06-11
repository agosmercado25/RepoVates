package com.selenium.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import com.selenium.pages.*;


public class DespegarTests1{
	private WebDriver navegador = null;
	
	@BeforeClass(alwaysRun=true)
	public void NavegadorTest(ITestContext context) throws Exception {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegadorSuite = navegadorTestSuite != null ? navegadorTestSuite : "EDGE";
		navegador = DriverFactory.LevantarBrowser(null, navegadorSuite, "https://www.despegar.com.ar/");
	}
	
//	@Test(dataProvider = "dataProviderDespegar", description = "Validar seleccionar alojamineto con destino y fechas con 3 adultos y un menor")
//	public void AlojamientoTest(String lugares) throws Exception{
//		DespegarPrincipalPage home = new DespegarPrincipalPage(navegador);
//		Assert.assertTrue(home.DespegarVisible(),"Error! No se pudo acceder a la pagina");
//		home.iraAlojamiento();
//		DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(navegador);
//		alojamiento.alojamiento(lugares);
//		DespegarBuscarPage result = new DespegarBuscarPage(navegador);
//		Assert.assertTrue(result.Resultado(),"Todas las reservas para ese lugar se encuentran ocupadas.");
//	}
	
	@Test(groups= {"grupo2"}, description="Validar que se puede alojar en Mendoza")
	public void AlojamientoTest() throws Exception{
		DespegarPrincipalPage home = new DespegarPrincipalPage(navegador);
		Assert.assertTrue(home.DespegarVisible(),"Error! No se pudo acceder a la pagina");
		home.iraAlojamiento();
		DespegarAlojamientoPage alojamiento = new DespegarAlojamientoPage(navegador);
		alojamiento.alojamiento("Mendoza");
		DespegarBuscarPage result = new DespegarBuscarPage(navegador);
		Assert.assertTrue(result.hotelExist());
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		navegador.close();
	}
	
	@DataProvider (name = "dataProviderDespegar")
	  public Object[][] metodoDP(){
		  return new Object[][] { {"Mendoza"},{"San Salvador de Jujuy"},{"Villa Carlos Paz"} };
	}
}
