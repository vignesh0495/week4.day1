package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {
	public static void main(String[] args) {
		//setup the driver
		WebDriverManager.chromedriver().setup();
		// launch the browser
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		// To maximize window
		driver.manage().window().maximize();
		//switch to frame
		driver.switchTo().frame(1);
		WebElement frame2 = driver.findElement(By.id("frame2"));
		
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		
		//comes out of all frames
		
		driver.switchTo().defaultContent();
		
		String text = driver.findElement(By.tagName("h1")).getText();
		System.out.println(text);
		
	}
}
