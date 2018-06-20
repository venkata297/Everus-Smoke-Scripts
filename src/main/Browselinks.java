package main;

	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Browselinks {

		WebDriver driver;
		  @BeforeTest
		  public void openBro(){
			     driver= new FirefoxDriver();
			 	 driver.manage().window().setSize(new Dimension(1376,768));
			 	 //driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 driver.get("http://everus.org/");
		  }
		  
		  @Test
		  public void getLink(){
			  WebDriverWait wait1= new WebDriverWait(driver,20);
			  wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
			  List<WebElement> allLinks=driver.findElements(By.tagName("a"));
			  System.out.println(allLinks.size());
			  String[] linkTexts= new String [allLinks.size()];
			  int i=0;
			  
			  // extract text of each link in the page
			  for(WebElement elements:allLinks){
				  linkTexts[i]=elements.getText();
				  i++;
			  }
			  //Hit on each link 
			  for(String t:linkTexts){
				  driver.findElement(By.linkText(t)).click();
				  if(driver.getTitle().equals("not found")){
					  System.out.println("\"" + t + "\"" + "not working.");
				  }
				  else
				  {
					  System.out.println("\"" + t + "\"" + "is working.");
				  }
				  driver.navigate().back();
			  }
			  driver.quit();
		  }
	}



