package week4.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundSortable {

	public static void main(String[] args) {
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://www.leafground.com/pages/sorttable.html");
		
	List<WebElement> names = driver.findElements(By.xpath("//table[@id='table_id']//tr[@role='row']/td[2]"));
		
		
		List<String> text = new ArrayList<String>();
		
		List<String> wish = new ArrayList<String>();
		for (WebElement nam : names)			
		{
			text.add(nam.getText());
		}
		int length = text.size();
		System.out.println(text);
		for (int i = 1; i <= length; i++)
		{
			String text1 = driver.findElement(By.xpath("//table[@id='table_id']//tr[" +i+ "]/td[2]")).getText();
			wish.add(text1);
		}
		System.out.println(wish);
		if (text.equals(wish))
		{
			System.out.println("NAMES ARE SIMILAR");
		} 
		else
		{
			System.out.println("NAMES ARE DIFFERENT.");
		}
	}

}

}

	

	

		


