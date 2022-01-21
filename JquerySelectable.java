package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySelectable {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/selectable");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    driver.switchTo().frame(0);
		    Actions builder = new Actions(driver);
		       WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		       WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		       WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
	          WebElement  item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
	          WebElement  item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
	          WebElement  item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
	          WebElement  item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
	          builder.keyDown(Keys.CONTROL).click(item1)
	          .click(item2)
	          .click(item3)
	          .click(item4)
	          .click(item5)
	          .click(item6)
	          .click(item7)
	          .keyUp(Keys.CONTROL)
	          .perform();
	          
	}

}
