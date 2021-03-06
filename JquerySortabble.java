package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySortabble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 WebDriverManager.chromedriver().setup();
	     ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/sortable");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.switchTo().frame(0);
		    Actions builder = new Actions(driver);
		       WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		       WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		       WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
	       WebElement  item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		    builder.clickAndHold(item1)
		    .moveToElement(item6)
		    .release(item3)
		    .perform();
	}
	}


