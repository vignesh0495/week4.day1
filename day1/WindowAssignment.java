package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAssignment {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		//driver.switchTo().frame(1);
		driver.findElement(By.tagName("input")).sendKeys("Vignesh");
		
		WebElement checkbox = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(checkbox);
		
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		
		WebElement dropdown = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(dropdown);
		
		WebElement findElement = driver.findElement(By.id("animals"));
		Select drop=new Select(findElement);
		drop.selectByIndex(3);
		
		
	}


}
