package framework.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.managers.DriverManager;
import framework.utils.MethodsUtils;

/**
 * Стартовая страница
 */

public class StartPage extends Page{
		
	@FindBy(xpath = "//label[@class = ' kitt-top-menu__link kitt-top-menu__link_first kitt-top-menu__link_icons kitt-top-menu__link_wide']")
	private List<WebElement> serviceTypeLabelList;//Типы услуг
	
	@FindBy(xpath = "//a[@class = 'kitt-top-menu__link kitt-top-menu__link_second']")
	private List<WebElement> serviceLabelList;//Услуги
		
	/**
	 * Выбор раздела
	 */
	
	public void selectTypeService(String serviceTypeName) {
		
		for (WebElement element : serviceTypeLabelList) {
        	
        	String elementName = new WebDriverWait(DriverManager.getDriver(), 10)
        			.until(ExpectedConditions.elementToBeClickable(element))
        			.getAttribute("innerHTML");
       
        	
           if (MethodsUtils.russianLetters(elementName).equals(serviceTypeName)) {
        	   
        	    new WebDriverWait(DriverManager.getDriver(), 10)
           			.until(ExpectedConditions.elementToBeClickable(element))
           			.click();
            } 	
        }
		

	}
	
	/**
	 * Выбор услуги
	 */
	
	public void selectService(String serviceName) {
		
		for (WebElement element : serviceLabelList) {
        	
        	String elementName = element.getAttribute("innerHTML");

           if (elementName.contains(serviceName)) {
        	           	           	   
        	   new WebDriverWait(DriverManager.getDriver(), 10)
   				.until(ExpectedConditions.elementToBeClickable(element)).click();
        	   
        	   break;
            }
        }
       // Assertions.fail("Такой услуги нет: " + serviceName);
	}
}