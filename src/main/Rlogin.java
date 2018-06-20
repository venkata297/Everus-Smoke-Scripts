package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rlogin {
	
	WebDriver driver;
	@BeforeTest
	public void getLink(){
		driver= new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1376,768));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://staging.everus.org/signin");
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void login() throws NoSuchElementException{
		driver.findElement(By.id("useremail")).sendKeys("testuser11@uandme.org");
		driver.findElement(By.xpath("html/body/section/div/div/div/div/form/div[2]/input[2]")).sendKeys("Test@123");
		driver.findElement(By.xpath(".//*[@id='signIn']")).click();	
		}
		
		//Thread.sleep(100);
		//driver.switchTo().activeElement();
		//driver.findElement(By.xpath(".//*[@id='create-modal']/div/div/div/h5/a/span")).click();
	}


