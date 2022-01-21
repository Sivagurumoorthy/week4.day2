package week4.day2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ErailSortAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disableNotification");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		  
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement fromSta = driver.findElement(By.id("txtStationFrom"));
		fromSta.clear();
		fromSta.sendKeys("Chennai",Keys.TAB);
		
		WebElement toSta = driver.findElement(By.id("txtStationTo"));
		toSta.clear();
		toSta.sendKeys("Coimbatore",Keys.ENTER);
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
	
	
	List<String> train=new ArrayList();
	
	for(WebElement names:columns1) {
		String nametrains = names.getText();		
		train.add(nametrains);
		
	}
	System.out.println(train);

	}

}
