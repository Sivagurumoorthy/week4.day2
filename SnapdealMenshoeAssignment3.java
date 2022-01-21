package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealMenshoeAssignment3 {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    Actions builder = new Actions(driver);
	    WebElement mensfashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
	    builder.moveToElement(mensfashion).perform();
	    driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
	    Thread.sleep(100);
	    String text = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
	    System.out.println(text);
	    driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	    
	 WebElement from = driver.findElement(By.xpath("//input[@name='fromVal']"));
	 from.clear();
	 from.sendKeys("900");
	 
	 WebElement to = driver.findElement(By.xpath("//input[@name='toVal']"));
	 to.clear();
	 to.sendKeys("1200");
	    driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	    
     Thread.sleep(2000);
    
	driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
	
	Thread.sleep(1200);
	WebElement findElement = driver.findElement(By.xpath("//picture[@class='picture-elem']//img"));
	WebElement findElement2 = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
	builder.moveToElement(findElement).click(findElement2).perform();
	Thread.sleep(500);
	String text2 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
	System.out.println(text2);
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	
	File destination = new File("./images/HomeScreen.png");
	
	FileUtils.copyFile(screenshotAs, destination);
	
	
	
}

}
