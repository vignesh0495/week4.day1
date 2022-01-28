package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrame {
	public static void main(String[] args) {
		//setup the driver
		WebDriverManager.chromedriver().setup();
		// launch the browser
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		// maximize the window
		driver.manage().window().maximize();
		//enter the frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//moving to text alert
		 
		Alert set = driver.switchTo().alert();
		set.sendKeys("Vignesh");
		set.accept();
		
}

}
