package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
public static void main(String[] args) throws InterruptedException  {
		
		// Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the window
		driver.manage().window().maximize();
		// Enter UserName and Password 
		WebElement userName = driver.findElement(By.id("username"));

		userName.sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//go to mergecontacts
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//span[text()='From Contact']/following::a)[1]")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();
        //		driver.close();
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.xpath("(//span[text()='To Contact']/following::a)[1]")).click();
		Thread.sleep(3000);
		windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windows.get(1));
		// Click on contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(windows.get(0));
		String title3 = driver.getTitle();
		System.out.println(title3);
		driver.findElement(By.linkText("Merge")).click();
        //	accept alert	
		Alert alert = driver.switchTo().alert();
		alert.accept();
}
}