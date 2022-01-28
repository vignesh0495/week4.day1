package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class FrameLeafGround {
		public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		WebElement clickme = driver.findElement(By.xpath("//button[@id='Click']"));
		File screenshot= driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./images/Homescreen.png");
		FileUtils.copyFile(screenshot, destination);
		clickme.click();
		driver.switchTo().defaultContent();
		List<WebElement> iframe = (List<WebElement>) driver.findElements(By.tagName("iframe"));
		int count = iframe.size();
		System.out.println("The number of frames: "+count);
		
		}	

	}