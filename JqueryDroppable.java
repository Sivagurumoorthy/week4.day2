package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDroppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/droppable\r\n"+ "");
		    driver.manage().window().maximize();
		    driver.switchTo().frame(0);
		    
		    Actions builder = new Actions(driver);
		    
		    WebElement dragEle = driver.findElement(By.id("draggable"));
		    WebElement dropEle = driver.findElement(By.id("droppable"));
		Point location = dropEle.getLocation();
		    double x = location.getX();
		    double y = location.getY();
		   builder.dragAndDrop(dragEle, dropEle).perform();
	}

}
