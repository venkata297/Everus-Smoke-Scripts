package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Test_Allbuttons {
	
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void loadURL(String browser){
		
		if(browser.equals("Firefox")){
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Internet Explorer")){
			System.setProperty("webdriver.InternetExplorer.driver","C:\\Selenium\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		driver.manage().window().setSize(new Dimension(1376,768));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://laravel.everus.org/");
		}
    @Test(priority=1)
    public void Hitlogin(){
    	
    	Properties.userLogin.click();
    }
    @Test(priority=2)
    public void enterLogin(){
    	
    	Properties.userEmail.sendKeys("venkata.t@uandme.org");
    	Properties.userpassword.sendKeys("Test@345");
    	
    }
    @SuppressWarnings("unlikely-arg-type")
	@Test(priority=3)
    public void verifysendtoken(){
    	
    	try{    	
    	Boolean objdisplayed;
    	objdisplayed= Properties.sendToken.isDisplayed();
    	if(objdisplayed.equals("True")){
    		Properties.sendToken.click();
    	}
    	}catch(Exception e){
    		System.out.println("exception is" +e);
    	}
        }
    @SuppressWarnings("unlikely-arg-type")
	@Test(priority=4)
    public void verifysendbutton(){
    	try{  
    		JavascriptExecutor js= (JavascriptExecutor)driver;
    		js.executeScript("window.scrollBy(0,250)","");
    		
        	Boolean sendbutton_displayed;
        	sendbutton_displayed=driver.findElement(By.linkText("Send")).isDisplayed();
        	if(sendbutton_displayed.equals("True")){
        		driver.findElement(By.linkText("Send")).click();
        		driver.switchTo().alert().accept();
        	}
        	}catch(Exception e){
        		System.out.println("exception is" +e);
        	}
       }
    @SuppressWarnings("unlikely-arg-type")
	@Test(priority=5)
    public void verifyusersettings(){
    	try{
    	driver.findElement(By.linkText(" Return to Dashboard")).click();
    	Properties.userSettings.click();
    	JavascriptExecutor js1= (JavascriptExecutor)driver;
    	js1.executeScript("window.scrollBy(0,250)","");
    	Properties.SaveSettings.click();
    	driver.switchTo().alert().accept();
    	//Scroll down to bottom of page to hit the link Change transaction password
    	js1.executeScript("window.scrollBy(0,250)","");
    	driver.findElement(By.linkText("Change Transaction Password")).click();
    	Boolean settingssavebutton;
    	settingssavebutton=Properties.changepwd.isDisplayed();
    	if(settingssavebutton.equals("True")){
    		Properties.changepwd.click();
    		driver.switchTo().alert().accept();
    		JavascriptExecutor js2= (JavascriptExecutor)driver;
    		js2.executeScript("window.scrollBy(0,250)","");
    	}
    	}catch(Exception e)
    	{
    		System.out.println("exception is " +e);
    	}
    	
    }
    @Test(priority=6)
    public void verifyMyprofile(){
    	try{
    	Properties.myProfile.click();
    	Properties.changephoto.click();                             // change photo button
    	driver.switchTo().alert().dismiss();
    	JavascriptExecutor js3=(JavascriptExecutor)driver;
    	js3.executeScript("window.scrollBy(0,350)","");
    	Properties.submitprofil.click();                            //  submit profile button
    	
    	String expectederror="Nothing to update";
    	String actualerror= Properties.submitProfile_errorMessage.getText();
    	Assert.assertEquals(actualerror, expectederror);
    	}catch(Exception e){
    		System.out.println("exception is " + e);
    	}
    }
    @Test(priority=7)
    public void verify_BankInformation(){
    	try{
    	Properties.bankInfo.click();
    	Boolean IssetActive;
    	IssetActive=Properties.AddSetActive.isDisplayed();                   //Add&Set Active button validation
    	if(IssetActive.equals("True")){
    		Properties.AddSetActive.click();
    		String expectedtext="Select Bank";
    		String actualtext= Properties.selectBank.getText();
    		Assert.assertEquals(expectedtext, actualtext);
    	}
    	JavascriptExecutor js4=(JavascriptExecutor)driver;
    	js4.executeScript("window.scrollBy(0,250)","");
    	
    	// validate the behavior of Add Paypal button
    	Properties.Addpaypal.click();
    	String expectederror="Paypal Id is required";
    	String actualerror= Properties.payerror.getText();
    	Assert.assertEquals(expectederror,actualerror);
    	
    	// validate the behavior of Add Bitcoin button
    	Properties.Addbitcoin.click();
    	String expectederror1="Bitcoin Id is required";
    	String actualerror1= Properties.biterror.getText();
    	Assert.assertEquals(expectederror1, actualerror1);   			
    	
    	// Code to scroll up to start of the page to locate link "Return to dashboard"
    	WebElement element = driver.findElement(By.xpath(".//*[@id='page-wrapper']/section/div/a"));
    	((JavascriptExecutor) driver).executeScript(
    	                "arguments[0].scrollIntoView();", element);
    	}catch(Exception e){
    		System.out.println("exception is" + e);
    	}
        }
    @Test(priority=8)
    public void verify_passwordmanager(){
    	try{
    		// Click on the link Password manager
        	Properties.passwordManager.click();
        	// Scroll to bottom of the page and locate the Change password button
        	JavascriptExecutor js5=(JavascriptExecutor)driver;
        	js5.executeScript("window.scrollBy(0,250)","");
        	// Locate the Change password button
        	Properties.Changepass.click();
        	driver.switchTo().alert().accept();
        	// go to the top section of the page and hit on the link Return to Dashboard
        	WebElement element = driver.findElement(By.xpath(".//*[@id='page-wrapper']/section/div/a"));
        	((JavascriptExecutor) driver).executeScript(
        	                "arguments[0].scrollIntoView();", element);
        	element.click();
    	}catch(Exception e){
    		System.out.println("exception is" + e);
    	}
    }
    @AfterTest
    public void account_logout() throws InterruptedException{
    	Properties.webObj.click();
    	Thread.sleep(500);
    	// locate the logout button and hit on that
    	Properties.LogoutButton.click();
        }
    @AfterTest
    public void closeBrowser(){
    	driver.close();
    }
}
