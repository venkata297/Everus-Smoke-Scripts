package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Properties {

	WebDriver driver;
	
	@FindBy(id="useremail")
	static WebElement userEmail;
	
	@FindBy(name="userpwd")
	static WebElement userpassword;
	
	@FindBy(id="submitsettings")
	static WebElement SaveSettings;
	
	@FindBy(id="submitchangepwd")
	static WebElement changepwd;
	
	@FindBy(id="change-pic")
	static WebElement changephoto;
	
	@FindBy(id="submit-profile")
	static WebElement submitprofil;
	
	@FindBy(id="add_set_bnk")
	static WebElement AddSetActive;
	
	@FindBy(id="bankslist_error")
	static WebElement selectBank;
	
	@FindBy(id="add_paypal")
	static WebElement Addpaypal;
	
	@FindBy(id="add_bitcon")
	static WebElement Addbitcoin;
	
	@FindBy(id="paypal_error")
	static WebElement payerror;
	
	@FindBy(id="bitcoin_error")
	static WebElement biterror;
	
	@FindBy(id="login_pass")
	static WebElement Changepass;
	
	@FindBy(xpath=".//*[@id='primary-menu']/ul/li[5]/a")
	static WebElement userLogin;
	
	@FindBy(xpath=".//*[@id='page-wrapper']/section[2]/div/div[1]/div[2]/a[2]")
	static WebElement sendToken;
	
	@FindBy(xpath=".//*[@id='page-wrapper']/section[2]/div/div[1]/nav/ul/li[3]/a")
	static WebElement userSettings;
	
	@FindBy(xpath="html/body/div[2]/section/div/div[1]/nav/ul/li[2]/a")
	static WebElement myProfile;
	
	@FindBy(xpath=".//*[@id='fundsmsg']/font/strong")
	static WebElement submitProfile_errorMessage;
	
	@FindBy(xpath=".//*[@id='page-wrapper']/section/div/div[2]/div[1]/ul/li[2]/a")
	static WebElement bankInfo;
	
	@FindBy(xpath=".//*[@id='page-wrapper']/section/div/div[2]/div[1]/ul/li[3]/a")
	static WebElement passwordManager;
	
	@FindBy(xpath="html/body/div[2]/header/a[3]/i")
	static WebElement webObj;
	
	@FindBy(xpath="html/body/div[2]/header/div/div[3]/a/button")
	static WebElement LogoutButton;
}
