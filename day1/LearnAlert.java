package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {
	public static void main(String[] args) throws InterruptedException {
		//setup the driver
		WebDriverManager.chromedriver().setup();
		// launch the browser
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		//using text method in xpath
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello");
		Thread.sleep(3000);
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		
    //for holding alert sometime
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
	/* accept the alert can also be a function
	// ctrl + 2 + L to print text
		Alert alert = driver.switchTo().alert();
	//get the alert
		String text = alert.getText();
		System.out.println(text);
	//alert.dismiss(); ca be used both for alert
	//	enter the text for alert
		alert.sendKeys("TestLeaf");
		alert.accept();
	*/	
}
}