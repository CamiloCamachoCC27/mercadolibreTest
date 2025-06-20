package com.jbgroup.swd;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BuscarEnGoogleTest {
	
	@Test
	void buscarTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		      		
		driver.get("https://mercadolibre.com");
		
		WebElement pais = driver.findElement(By.id("MX"));
		pais.sendKeys(Keys.ENTER);
		
		WebElement buscador = driver.findElement(By.id("cb1-edit"));
		buscador.sendKeys("Play station 5");
		
		WebElement iconoBuscar = driver.findElement(By.className("nav-icon-search"));
		iconoBuscar.click();
		
		WebElement botonMasTarde = driver.findElement(By.xpath("//button[@data-js='onboarding-cp-close']"));
		botonMasTarde.click();
				
		WebElement botonAceptarCookies = driver.findElement(By.xpath("//button[@data-testid='action:understood-button']"));
		botonAceptarCookies.click();
		
		WebElement filtroNuevo = driver.findElement(By.xpath("//span[text()='Nuevo']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filtroNuevo);
		
		WebElement filtroNuevos = driver.findElement(By.xpath("//span[@class='ui-search-filter-name' and text()='Nuevo']"));
		filtroNuevos.click();
		
		Thread.sleep(3000); 
		
		WebElement filtroDistritoFederal = driver.findElement(By.xpath("//span[text()='Distrito Federal']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filtroDistritoFederal);
	
		WebElement filtroDistritoFederaldos = driver.findElement(By.xpath("//a[.//span[text()='Distrito Federal']]"));
		filtroDistritoFederaldos.click();
				
		WebElement botonOrdenar = driver.findElement(By.xpath("//span[text()='Más relevantes']/ancestor::button"));
		botonOrdenar.click();
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement opcionMenorPrecio = wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//span[text()='Menor precio']")));
		
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opcionMenorPrecio);
		wait.until(ExpectedConditions.elementToBeClickable(opcionMenorPrecio)).click();

		Thread.sleep(2000);
								
		WebElement primerProducto = driver.findElement(By.xpath("(//li[contains(@class,'ui-search-layout__item')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", primerProducto);
		
		Thread.sleep(2000);
		
		WebElement productoHorizon = driver.findElement(By.xpath("//img[@alt='Playstation 5 Digital Con Juego Horizon Forbidden West Laaca']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productoHorizon);
		
		Thread.sleep(6000);
	
						
		driver.quit();
		
	}

}
