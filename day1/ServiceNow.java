package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev99012.service-now.com/navpage.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Venkat@30");
		driver.findElement(By.id("sysverb_login")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys("incidents");
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[1]")).click();
		driver.findElement(By.id("sysverb_new")).click();
		String incidentnumber = driver.findElement(By.id("incident.number")).getText();
		System.out.println(incidentnumber);
		
		driver.findElement(By.id("sys_display.incident.caller_id")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> child=new ArrayList<String>(windowHandles);
		String str = child.get(1);
		driver.switchTo().window(str);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		//driver.switchTo().defaultContent();
		driver.switchTo().window(child.get(0));
		driver.switchTo().frame("gsft_main");

		driver.findElement(By.id("incident.short_description")).sendKeys("TestLeaf Software");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(3000);
		
		
		String searchnumber = driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
		WebElement findElement = driver.findElement(By.id("incident_table_header_search_control"));
		findElement.sendKeys(searchnumber);
		findElement.sendKeys(Keys.ENTER);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./images/serviceNow.png");
		FileUtils.copyFile(source, destination);
		

	}


}
