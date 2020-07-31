package framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static framework.utils.PropertiesConstantUtils.*;

public class DriverManager {

    private static WebDriver driver;
    
    private static PropertiesManager props = PropertiesManager.getPropertiesManager();
    
    private DriverManager(){
    }

    public static WebDriver getDriver() {
        if(driver == null) {
        	
        	ChromeOptions chromeOptions= new ChromeOptions();
   		    chromeOptions.setBinary("C:\\Users\\Viktor\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"); 
		    System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER));
		    driver = new ChromeDriver(chromeOptions);		   
		    
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}