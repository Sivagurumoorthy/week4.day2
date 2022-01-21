package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment2 {

	public static void main(String[] args) throws InterruptedException {
				
	     	WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
	     	driver.get("https://www.nykaa.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        Actions builder = new Actions(driver);
	        WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	        builder.moveToElement(brands).perform();
	        
	        Thread.sleep(100);
	        driver.findElement(By.linkText("L'Oreal Paris")).click();
	        String title = driver.getTitle();
	        System.out.println(title);
	        driver.findElement(By.xpath("//span[text()='Avg Customer Rating']")).click();
	        driver.findElement(By.xpath("//span[text()='4 stars & above']")).click();
	        driver.findElement(By.xpath("//span[text()='Category']")).click();
	        driver.findElement(By.xpath("//span[text()='Hair']")).click();
	        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	        driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
	        driver.findElement(By.xpath("//span[text()='Concern']")).click();
	        driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	        driver.findElement(By.xpath("//div[@class='css-10zjw4o']")).click();
	        Set<String> windowHandles = driver.getWindowHandles();
	        List<String> windows = new ArrayList<String>(windowHandles);
	    		  String childwindow = windows.get(1);
	    		  driver.switchTo().window(childwindow);
	    Thread.sleep(200);
        String text = driver.findElement(By.xpath("//span[text()='₹150']")).getText();
        System.out.println("MRP");
        System.out.println(text);
	   
	    driver.findElement(By.xpath("//span[@class='btn-text'][text()='ADD TO BAG']")).click();
	    driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
	    Thread.sleep(200);
	    driver.switchTo().frame(0);
	    String text2 = driver.findElement(By.xpath("//div[@class='first-col']/div[@class='value']")).getText();
	    System.out.println("GRAND TOTAL");
	    System.out.println(text2);
	     driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
	     
	     Thread.sleep(100);
	    driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
	    String text3 = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[@class='value']")).getText();
	    if (text2.equalsIgnoreCase(text3)) {
	    	
	    	System.out.println("Value is Same");
	    } else {
	    	
	    	System.out.println("Value is different");
	    }
	    
	    driver.quit();
	    
	    
	    
	    
}}