package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryResizable {

	public static void main(String[] args) {
	
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/resizable");
		    driver.manage().window().maximize();
		    driver.switchTo().frame(0);
		    Actions builder = new Actions(driver);
		    WebElement dragEle = driver.findElement(By.id("resizable"));
		  
		 Point location = dragEle.getLocation();
		    double x = location.getX();
		    double y = location.getY();
		   builder.dragAndDropBy(dragEle, 20, 60).perform();

	}

}

