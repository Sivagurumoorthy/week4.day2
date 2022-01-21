package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		Thread.sleep(20);
		String text = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]")).click();
        Thread.sleep(10);
		String text2 = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).getText();
		System.out.println(text2);
		Thread.sleep(10);
		WebElement element = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']//img[@data-image-index='1']"));
		element.click();
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./images/Screen.png");
		
		FileUtils.copyFile(screenshotAs, destination);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		String text3 = driver.findElement(By.xpath("//div[@data-name='Subtotals']")).getText();
		System.out.println(text3);
		if (text2.equalsIgnoreCase(text3)) {
			
			System.out.print("total is different");
		} else {
			System.out.println("VERIFIED");
		}
	}

}
