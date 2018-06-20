package main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Omtech_brokenlinks {

	WebDriver driver;
	  @BeforeTest
	  public void openBro(){
		     driver= new InternetExplorerDriver();
		     driver.manage().window().setSize(new Dimension(1376,768));
			 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			 String URL=" https://uat.everus.org/webnew/";
			 driver.get(URL);
			 verifyLinkActive(" https://uat.everus.org/webnew/");
	  }
	  
	  @Test
	   public void getbrokenlinks(){
		     List<WebElement> links= driver.findElements(By.tagName("a"));
		     System.out.println("Total no of links" + links.size());
		     for(int i=0;i<links.size();i++){
		    	 WebElement ele1= links.get(i);
		    	 String url= ele1.getAttribute("href");
		    	 verifyLinkActive(" https://uat.everus.org/webnew/");
		     }
	     }
	    public static void verifyLinkActive(String Url){
	    	try{
	    		URL url1=new URL(Url);
	    		HttpURLConnection httpurlconnect= (HttpURLConnection)url1.openConnection();
	    		httpurlconnect.setConnectTimeout(3000);
	    		httpurlconnect.connect();
	    		if(httpurlconnect.getResponseCode()==200){
	    			System.out.println(Url+" -"+ httpurlconnect.getResponseMessage());
	    		}
	    		if(httpurlconnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
	    			System.out.println(Url+" - "+httpurlconnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	    		}
	    	}catch(Exception e){
	    		System.out.println("Exception is" + e);
	    	}
	    }
	    
	    @AfterTest
	    public void closeBrowser(){
	    	driver.close();
	    }

}
