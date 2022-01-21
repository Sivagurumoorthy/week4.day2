package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
			driver.get("https://erail.in/");
		    driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  WebElement from = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		  from.clear();
		  from.sendKeys("MS");
		  Thread.sleep(15);
		  from.sendKeys(Keys.TAB);
		  WebElement to = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		 to.clear();
		 to.sendKeys("MDU");
		 Thread.sleep(15);
		 to.sendKeys(Keys.ENTER);
		driver.findElement(By.id("buttonFromTo")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int size = rows.size();
		System.out.println(size);
		 List<WebElement> columns = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> rowl = table.findElements(By.tagName("tr"));
		int size1 = rowl.size();
		System.out.println(size1);
		 List<WebElement> columns1 = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		 
		int size2 = columns1.size();
		System.out.println(size2);
		
	String text = columns1.get(1).getText();
	System.out.println(text);
	}

}
