package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDraggable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.switchTo().frame(0);
	    
	    Actions builder = new Actions(driver);
	    
	    Thread.sleep(200);
	    WebElement dragEle = driver.findElement(By.id("draggable"));
        builder.dragAndDropBy(dragEle, 100, 150).perform();
	}

}
